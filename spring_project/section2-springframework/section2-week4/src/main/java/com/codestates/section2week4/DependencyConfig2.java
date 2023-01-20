package com.codestates.section2week4;


import com.codestates.section2week4.member.MemberRepository;
import com.codestates.section2week4.member.MemberService;
import com.codestates.section2week4.nocompoMember.MemberRepositoryNC;
import com.codestates.section2week4.nocompoMember.MemberServiceNC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이건 내가 막 만든 클래스다.
// Configuration 과 @Bean으로 생성된 클래스
@Configuration
public class DependencyConfig2 {
//    @Bean
//    public MemberServiceNC memberServiceNc() {
//        return new MemberServiceNC(memberRepositorync());
//    }
//    @Bean
//    public MemberRepositoryNC memberRepositorync() {
//        return new MemberRepositoryNC();
//    }

    @Bean
    public MemberService memberService2() {
        return new MemberService(memberRepository2());
    }
    @Bean
    public MemberRepository memberRepository2() {
        return new MemberRepository();
    }
}
