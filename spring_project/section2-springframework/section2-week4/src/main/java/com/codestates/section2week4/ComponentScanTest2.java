package com.codestates.section2week4;

import com.codestates.section2week4.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class ComponentScanTest2 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);

//        ApplicationContext ac2 = new AnnotationConfigApplicationContext(DependencyConfig2.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        System.out.println(memberService);
    }
    // Case 1)  DependencyConfig.class를 @ComponentScan 으로 한다.
//    결과 : DependencyConfig.class 으로 컨테이너를 생성했지만, @Component 담고있는 @Configuration으로 설정정보를 나타내는 DependencyConfig2.class도 Bean으로 등록되는 모습을 보인다.

    // Case 2) DependencyConfig.class를 @ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)) 으로 한다.
    // Configuration을 스캔 대상에서 제외시키는 코드이다.
//    결과 : DependencyConfig.class 으로 컨테이너를 생성했을때, @Configuration를 가진 DependencyConfig2.class는 스캔 대상에서 제외되어 Bean으로 생성되지 않는다.

    // Case 3) 같은 조건에서 ac2 즉 컨테이너를 생성한다면,
//     결과 : 스캔 대상이 아니라 컨테이너를 생성하면서 동시에 Bean들을 등록한다.
}
