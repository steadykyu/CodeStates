package com.codestates.order.service;

import com.codestates.coffee.service.CoffeeService;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.service.MemberService;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    final private OrderRepository orderRepository;
    final private MemberService memberService;
    final private CoffeeService coffeeService;

    public OrderService(OrderRepository orderRepository, MemberService memberService, CoffeeService coffeeService) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.coffeeService = coffeeService;
    }

    public Order createOrder(Order order) {
        //(1) Aggregate 필드를 가져와, 필요한 memberID를 가져오는 모습
        memberService.findVerifiedMember(order.getMemberId().getId());

        //(2) Order 속에 있는 커피가 존재하는지 검증해보고 주문을 저장한다.
        // 연관관계가 되어있으므로 이렇게 객체식으로 처리해도 괜찮다.
        order.getOrderCoffees()
                .stream()
                .forEach(coffeeRef -> {
                    coffeeService.findVerifiedCoffee(coffeeRef.getCoffeeId());
                });
        // 예외가 안떴으면 저장해준다.
        return orderRepository.save(order);
    }

    public Order findOrder(long orderId) {
        return findVerifiedOrder(orderId);
    }


    public List<Order> findOrders() {
        return (List<Order>)orderRepository.findAll();
    }

    public void cancelOrder(long orderId) {
        Order findOrder = findVerifiedOrder(orderId);
        int step = findOrder.getOrderStatus().getStepNumber();

        if(step >= 2){
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }

        findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(findOrder);
    }

    public Order findVerifiedOrder(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order findOrder = optionalOrder.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
        return findOrder;
    }
}
