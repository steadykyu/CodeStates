package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.helper.event.MemberRegistrationApplicationEvent;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.stamp.Stamp;
import com.codestates.utils.CustomBeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

/**
 *  - 메서드 구현
 *  - DI 적용
 *  - Spring Data JPA 적용
 *  - 트랜잭션 적용
 */
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;
    private final R2dbcEntityTemplate template;       // (2)

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils, R2dbcEntityTemplate template) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
        this.template = template;
    }

    public Mono<Member> createMember(Member member) {
        return verifyExistEmail(member.getEmail())
                .then(memberRepository.save(member))
                .map(resultMember -> {
                    //Stamp 저장
                    template.insert(new Stamp(resultMember.getMemberId())).subscribe();

                    return resultMember;
                });
    }

    public Mono<Member> updateMember(Member member) {
        return findVerifiedMember(member.getMemberId())    // (6)
                .map(findMember -> beanUtils.copyNonNullProperties(member, findMember))  // (7)
                .flatMap(updatingMember -> memberRepository.save(updatingMember));    // (8)
    }

    @Transactional(readOnly = true)
    public Mono<Member> findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    @Transactional(readOnly = true)
    public Mono<Page<Member>> findMembers(PageRequest pageRequest) {
        return memberRepository.findAllBy(pageRequest)  // (9)
                .collectList()     // (10)
                .zipWith(memberRepository.count())   // (11)
                .map(tuple -> new PageImpl<>(tuple.getT1(), pageRequest, tuple.getT2()));  // (12)
    }

    public Mono<Void> deleteMember(long memberId) {
        return findVerifiedMember(memberId)
                .flatMap(member -> template.delete(query(where("MEMBER_ID").is(memberId)), Stamp.class))  // (13)
                .then(memberRepository.deleteById(memberId));              // (14)
    }

    private Mono<Member> findVerifiedMember(long memberId) {
        return memberRepository
                .findById(memberId)
                .switchIfEmpty(Mono.error(new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND))); // (17)
    }

    private Mono<Void> verifyExistEmail(String email) {
        return memberRepository.findByEmail(email)
                .flatMap(findMember -> {
                    if (findMember != null) {
                        return Mono.error(new BusinessLogicException(ExceptionCode.MEMBER_EXISTS)); // (15)
                    }
                    return Mono.empty();    // (16)
                });
    }
}
