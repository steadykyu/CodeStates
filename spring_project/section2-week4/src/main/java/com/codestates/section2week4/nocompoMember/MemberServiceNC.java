package com.codestates.section2week4.nocompoMember;


public class MemberServiceNC {
    private final MemberRepositoryNC memberRepository;

    public MemberServiceNC(MemberRepositoryNC memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(MemberNC memberNC) {
        memberRepository.postMember(memberNC);
    }

    public MemberNC getMember(Long memberId) {
        return memberRepository.getMember(memberId);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteMember(memberId);
    }
}
