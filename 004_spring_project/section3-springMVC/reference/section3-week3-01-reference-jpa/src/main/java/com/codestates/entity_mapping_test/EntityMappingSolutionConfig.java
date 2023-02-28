package com.codestates.entity_mapping_test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * 연관 관계 매핑 결과 테스트
 */
@Profile("entity-mapping-solution")
@EntityScan(basePackageClasses = {EntityMappingSolutionConfig.class})
@Configuration
public class EntityMappingSolutionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: entity-mapping-solution");

        return args -> registerOrder();
    }

    private void registerOrder() {
//         원래의 Test
//        tx.begin();
//        Member member = new Member("hgd@gmail.com", "Hong Gil Dong", "010-1111-1111");
//        Stamp stamp = new Stamp();
//        Order order = new Order();
//        Coffee coffee = new Coffee("카페라떼", "Cafe Latte", 4000, "CFL");
//
//        OrderCoffee orderCoffee = new OrderCoffee();
//        orderCoffee.setQuantity(3);
//        stamp.setStampCount(orderCoffee.getQuantity());
//
//        member.addStamp(stamp);
//        member.addOrder(order);
//        orderCoffee.addCoffee(coffee);
//        orderCoffee.addOrder(order);
//
//        em.persist(coffee);
//        em.persist(member);
//        em.persist(stamp);
//        em.persist(order);
//        em.persist(orderCoffee);
//
//        tx.commit();
//
//        Order resultOrder = em.find(Order.class, 1L);
//
//        resultOrder.getOrderCoffees().stream()
//                .forEach(resultOrderCoffee -> {
//                    Coffee orderedCoffee = resultOrderCoffee.getCoffee();
//                    System.out.printf("# 주문정보- 커피명: %s(%s), 주문 수량: %d",
//                            orderedCoffee.getKorName(), orderedCoffee.getEngName(), resultOrderCoffee.getQuantity());
//                });

        // 혼자해본 Test
        tx.begin();
        // 주문생성
        // order1 -> 아메리카노 2잔을 주문 했다고 가정(총2잔)
        Order order1 = new Order();

        // 커피 생성
        Coffee americano = new Coffee("아메리카노","Americano",5000, "AME");
        Coffee caramelLatte = new Coffee("카라멜 라떼", "Caramel Latte",6000,"CLT");

        // 영속성 컨테이너에 저장
        em.persist(americano);
        em.persist(caramelLatte);

        // OrderCoffee 생성
        OrderCoffee order1AME = new OrderCoffee();
        order1AME.setQuantity(2);

        // order1 -> 아메리카노 2잔을 주문 했다고 가정(총2잔)
        // 편의 메서드를 통해 알아서 양쪽에 들어간다.
        order1AME.addOrder(order1);

        // 커피주입
        order1AME.addCoffee(americano);

        // 영속성 컨텍스트에 주문과 주문정보 생성
        em.persist(order1);
        em.persist(order1AME);
        tx.commit();
        // 주문 1 조회
        Order findOrder1 = em.find(Order.class, 1L);

        findOrder1
                .getOrderCoffees()
                .stream()
                .forEach(orderCoffee -> {
                    System.out.println("커피명 : " + orderCoffee.getCoffee().getKorName() +
                            ", 커피수량 : " + orderCoffee.getQuantity());
                });

        System.out.println("<-----------두번재 주문 : 아메리카노, 카라멜을 각각 1잔을 주문 했다고 가정--------->");
        tx.begin();
//         order2 -> 아메리카노, 카라멜을 각각 1잔을 주문 했다고 가정
//      한 주문속의 다른 종류의 커피 이므로 두개의 OrderCoffee가 필요하다
        Order order2 = new Order();
        OrderCoffee order2AME = new OrderCoffee();
        OrderCoffee order2CLT = new OrderCoffee();

//         order2 -> 아메리카노, 카라멜라떼를 각각 1잔을 주문 했다고 가정(총2잔)
        order2AME.addCoffee(americano);
        order2AME.setQuantity(1);
        order2CLT.addCoffee(caramelLatte);
        order2CLT.setQuantity(1);

        // 커피 정보를 담은 orderCoffee들을 order2에 넣어줌
        // 편의 메서드가 있어서 한번만 주입하면 양쪽에 들어간다. !! -> 너무편한!!
        order2.addOrderCoffee(order2AME);
        order2.addOrderCoffee(order2CLT);

        // 주문과 주문정보를 영속성 컨테이너에 저장
        em.persist(order2);
        em.persist(order2AME);
        em.persist(order2CLT);
        tx.commit(); // 저장된 엔티티들을 만들도록 쿼리를 보낸다.

        Order findOrder2 = em.find(Order.class, 2L);

        // 주문의 주문정보에서 커피정보 조회하기
        findOrder2.getOrderCoffees()
                .stream()
                .forEach(orderCoffee ->
                        System.out.println("커피명 : " + orderCoffee.getCoffee().getKorName() +
                                ", 커피수량 : " + orderCoffee.getQuantity()));
    }
}
