package com.codestates.member.controller;

import com.codestates.dto.MultiResponseDto;
import com.codestates.dto.SingleResponseDto;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import com.codestates.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;


/**
 * - DI 적용
 * - Mapstruct Mapper 적용
 * - @ExceptionHandler 적용
 */
@RestController
@RequestMapping("/v12/members")
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;
    private final String MEMBER_DEFAULT_URL = "/v12/members";
    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public Mono<ResponseEntity> postMember(@Valid @RequestBody Mono<MemberDto.Post> requestBody){
        return requestBody
                .flatMap(post -> memberService.createMember(mapper.memberPostToMember(post)))  // (2)
                .map(createdMember -> {
                    URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId());
                    return ResponseEntity.created(location).build();
                });
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(
            @PathVariable("member-id") @Positive long memberId,
            @Valid @RequestBody Mono<MemberDto.Patch> requestBody) {
        Mono<MemberDto.Response> response =
                requestBody
                        .flatMap(patch -> {            // (4)
                            patch.setMemberId(memberId);
                            return memberService.updateMember(mapper.memberPatchToMember(patch));
                        })
                        .map(member -> mapper.memberToMemberResponse(member));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Mono<MemberDto.Response> response =
                memberService.findMember(memberId)   // (5)
                        .map(member -> mapper.memberToMemberResponse(member));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestParam("page") @Positive int page,
                                     @RequestParam("size") @Positive int size) {
        Mono<List<MemberDto.Response>> response =
                memberService.findMembers(PageRequest.of(page - 1, size, Sort.by("memberId").descending()))  // (6)
                        .map(pageMember -> mapper.membersToMemberResponses(pageMember.getContent()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        Mono<Void> result = memberService.deleteMember(memberId);    // (7)
        return new ResponseEntity(result, HttpStatus.NO_CONTENT);
    }
}
