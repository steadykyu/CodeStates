package com.codestates.n_plus_one_problem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Profile("n-plus-one-problem")
@EntityScan(basePackageClasses = {NPlusOneProblemConfig.class})
@Configuration
public class NPlusOneProblemConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaFetchStrategyRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: many-to-one-bi");

        return args -> {
//            nPlusOneProblemExample();   // N + 1 문제가 발생하는 예제
            fetchJoinJPQLTest();            // Fetch Join을 이용해서 한 번에 가져오기
        };
    }
    private void createMemberOrder(){
        tx.begin();
        // 회원 정보가 3명이라고 하자.
        Member member1 = new Member("hgd@gmail.com", "Hong Gil Dong", "010-1111-1111");
        Member member2 = new Member("hgd2@gmail.com", "Kyu Ha Kim", "010-1234-5678");
        Member member3 = new Member("hgd3@gmail.com", "Yuri Kim", "010-1444-7111");

        // 주문 정보는 6개이다.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        Order order5 = new Order();
        Order order6 = new Order();

        // 각 회원 -> 3개 2개 1개 주문을 가진다.
        member1.addOrder(order1);member1.addOrder(order2);member1.addOrder(order3);
        member2.addOrder(order4);member2.addOrder(order5);
        member3.addOrder(order6);

        order1.addMember(member1);order2.addMember(member1);order3.addMember(member1);
        order4.addMember(member2);order5.addMember(member2);
        order6.addMember(member3);

        // 모두 영속화 시켜준다.
        em.persist(member1);em.persist(member2);em.persist(member3);

        em.persist(order1);em.persist(order2);em.persist(order3);
        em.persist(order4);em.persist(order5);em.persist(order6);
        tx.commit();

        em.clear();
    }
    private void nPlusOneProblemExample() throws InterruptedException {
        createMemberOrder();

        // JPQL 사용
        TypedQuery<Member> query =
                em.createQuery("select m from Member m", Member.class);

        List<Member> resultMember = query.getResultList();

//        resultMember.stream()
//                .map(member -> member.getOrders())
//                .flatMap(orders -> orders.stream())
//                .forEach(order -> System.out.println("# orderId: " + order.getOrderId()));

    }

    private void fetchJoinJPQLTest() throws InterruptedException {
        createMemberOrder();

        // JPQL 사용
        TypedQuery<Member> query =
                em.createQuery("select m from Member m join fetch m.orders p", Member.class);

        List<Member> findMembers = query.getResultList();

        System.out.println(findMembers.size());
    }
}

