package com.codestates.section2week4;

import com.codestates.section2week4.member.MemberService;
import com.codestates.section2week4.singleton.SingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    static DependencyConfig dependencyConfig = new DependencyConfig();
// DI 컨테이너
//    static MemberService memberService1 = dependencyConfig.memberService();
//    static MemberService memberService2 = dependencyConfig.memberService();

// 싱글톤 패턴
//    static SingletonService singletonService1 = SingletonService.getInstance();
//    static SingletonService singletonService2 = SingletonService.getInstance();

//    싱글톤 컨테이너
    static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
    static MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    static MemberService memberService2 = ac.getBean("memberService", MemberService.class);

    public static void main(String[] args) {
        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 : " + memberService2);
    }
}
