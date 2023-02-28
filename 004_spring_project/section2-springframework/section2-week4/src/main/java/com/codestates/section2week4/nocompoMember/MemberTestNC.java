package com.codestates.section2week4.nocompoMember;

import com.codestates.section2week4.DependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberTestNC {
    public static void main(String[] args) {
//        DependencyConfig dependencyConfig = new DependencyConfig();
//        MemberService memberService = dependencyConfig.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);

        MemberServiceNC memberService = ac.getBean("memberService", MemberServiceNC.class);

        MemberNC memberNC = new MemberNC(0L, "lucky@codestates.com", "KimLucky", "010-1234-5678");
        memberService.createMember(memberNC);

        MemberNC currentMemberNC = memberService.getMember(0L);

        System.out.println("회원 가입한 유저 : " + memberNC.getName());
        System.out.println("현재 첫번째 유저 : " + currentMemberNC.getName());

        if(memberNC.getName().equals(currentMemberNC.getName())) {
            System.out.println("새롭게 가입한 사용자와 현재 사용자가 같습니다.");
        }

        memberService.deleteMember(0L);

        if(memberService.getMember(0L) == null) {
            System.out.println("회원 삭제가 정상적으로 완료되었습니다.");
        }
    }
}
