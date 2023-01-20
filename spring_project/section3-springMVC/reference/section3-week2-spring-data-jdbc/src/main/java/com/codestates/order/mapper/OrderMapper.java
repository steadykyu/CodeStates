package com.codestates.order.mapper;

import com.codestates.coffee.entity.Coffee;
import com.codestates.order.dto.*;
import com.codestates.order.entity.CoffeeRef;
import com.codestates.coffee.service.CoffeeService;
import com.codestates.order.entity.Order;
import com.codestates.order.entity.Order2;
import com.codestates.order.entity.ReadableOrderCoffee;
import com.google.common.collect.Streams;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    // Entity에서 매핑을 처리하는 케이스. Order2와 예시로 사용될 수 있습니다.
//    Order2 orderPostDtoToOrder(OrderPostDto orderPostDto);

    default Order orderPostDtoToOrder(OrderPostDto orderPostDto) {
        Order order = new Order();
        order.setMemberId(new AggregateReference.IdOnlyAggregateReference(orderPostDto.getMemberId()));
        Set<CoffeeRef> orderCoffees =
                orderPostDto.getOrderCoffees()
                        .stream()
                        .map(orderCoffeeDto ->
                                new CoffeeRef(orderCoffeeDto.getCoffeeId(), orderCoffeeDto.getQuantity()))
                .collect(Collectors.toSet());
        order.setOrderCoffees(orderCoffees);

        return order;
    }

//    default OrderResponseDto2 orderToOrderResponseDto(Order order);   // ResponseDto에서 더 많은 일을 하게 되는 케이스

    default OrderResponseDto orderToOrderResponseDto(CoffeeService coffeeService,
                                                     Order order) {

        long memberId = order.getMemberId().getId();

        List<OrderCoffeeResponseDto> orderCoffees =
                orderToOrderCoffeeResponseDtoV2(coffeeService, order.getOrderCoffees());
//        orderToOrderCoffeeResponseDto(coffeeService, order.getOrderCoffees());

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderCoffees(orderCoffees);
        orderResponseDto.setMemberId(memberId);
        orderResponseDto.setCreatedAt(order.getCreatedAt());
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setOrderStatus(order.getOrderStatus());

        // TODO 주문에 대한 더 자세한 정보로의 변환은 요구 사항에 따라 다를 수 있습니다.

        return orderResponseDto;
    }

    default List<OrderCoffeeResponseDto> orderToOrderCoffeeResponseDto(
                                                        CoffeeService coffeeService,
                                                        Set<CoffeeRef> orderCoffees) {
        return orderCoffees.stream()
                .map(coffeeRef -> {
                    Coffee coffee = coffeeService.findCoffee(coffeeRef.getCoffeeId()); // N + 1 이슈 발생

                    return new OrderCoffeeResponseDto(coffee.getCoffeeId(),
                            coffee.getKorName(),
                            coffee.getEngName(),
                            coffee.getPrice(),
//                            coffee.getPrice().getValue(), // Money 타입을 사용할 경우
                            coffeeRef.getQuantity());
                }).collect(Collectors.toList());
    }

    // N + 1 이슈가 없는 개선된 orderToOrderCoffeeResponseDto 버전
    default List<OrderCoffeeResponseDto> orderToOrderCoffeeResponseDtoV2(CoffeeService coffeeService,
                                                                         Set<CoffeeRef> orderCoffees) {
        // 주문한 커피의 coffeeId만 수집
        List<Long> coffeeIds =
                orderCoffees.stream()
                        .map(coffeeRef -> coffeeRef.getCoffeeId())
                        .collect(Collectors.toList());

        // 한번의 쿼리로 주문한 커피 정보 조회
        List<Coffee> coffees = coffeeService.findAllCoffeesByIds(coffeeIds);

        // 조회된 커피(Coffee 엔티티)를 OrderCoffeeResponseDto로 변환
        // coffeeId를 기준으로 정렬 후, Guava Streams를 이용해 zipping 한다.
            //  List<coffee> 와 List<CoffeeRef> stream들 각각 요소에 존재하는 필드값들을 이용하여 DTO를 생성했다.
        return Streams
                .zip(
                        coffees.stream().sorted(comparing(Coffee::getCoffeeId)),
                        orderCoffees.stream().sorted(comparing(CoffeeRef::getCoffeeId)),
                        (coffee, coffeeRef) -> new OrderCoffeeResponseDto(coffee.getCoffeeId(),
                                coffee.getKorName(),
                                coffee.getEngName(),
                                coffee.getPrice(),
//                            coffee.getPrice().getValue(), // Money 타입을 사용할 경우
                                coffeeRef.getQuantity()))
                .collect(Collectors.toList());
    }

    // N + 1 이슈가 없는 네이티브 쿼리를 이용해 읽기 전용 엔티티 클래스에서 주문한 커피 정보를 매핑하는 버전
    default List<OrderResponseDto> readableOrderCoffeeToOrderResponseDto(List<ReadableOrderCoffee> orders) {
        // ReadableOrderGroupDto의 필드 기준으로 그룹핑 한다.
        Map<ReadableOrderGroupDto, List<ReadableOrderCoffee>> grouped =
                orders.stream().collect(
                        Collectors.groupingBy(readableOrderCoffee -> new ReadableOrderGroupDto(readableOrderCoffee)));

        List<OrderResponseDto> orderResponseDtos =
                grouped.entrySet().stream()
                        .map(e -> {
                            ReadableOrderGroupDto groupDto = e.getKey();  // 그룹핑한 필드 정보를 EntrySet key에서 얻는다.
                            List<ReadableOrderCoffee> readableOrderCoffees = e.getValue();  // 그룹핑 된 주문한 커피 정보를 얻는다.

                            // 주문 정보 매핑
                            OrderResponseDto orderResponseDto = new OrderResponseDto();
                            orderResponseDto.setOrderId(groupDto.getOrderId());
                            orderResponseDto.setMemberId(groupDto.getMemberId());
                            orderResponseDto.setOrderStatus(groupDto.getOrderStatus());
                            orderResponseDto.setCreatedAt(groupDto.getCreatedAt());

                            // 주문한 커피 정보 매핑. ReadableOrderCoffee를 OrderCoffeeResponseDto로 변환한다.
                            List<OrderCoffeeResponseDto> orderCoffeeResponseDtos =
                                    readableOrderCoffeeToOrderCoffeeResponseDto(readableOrderCoffees);

                            orderResponseDto.setOrderCoffees(orderCoffeeResponseDtos);

                            return orderResponseDto;
                        }).collect(Collectors.toList());

        // 최근 주문 순으로 정렬
        orderResponseDtos.sort(comparing(OrderResponseDto::getOrderId).reversed());
//        Collections.sort(orderResponseDtos, Comparator.comparing(OrderResponseDto::getOrderId).reversed());
        return orderResponseDtos;
    }

    default List<OrderCoffeeResponseDto> readableOrderCoffeeToOrderCoffeeResponseDto(
            List<ReadableOrderCoffee> readableOrderCoffees) {
        return readableOrderCoffees.stream()
                .map(readableOrderCoffee -> {
                    OrderCoffeeResponseDto orderCoffeeResponseDto =
                            new OrderCoffeeResponseDto(readableOrderCoffee.getCoffeeId(),
                                    readableOrderCoffee.getKorName(),
                                    readableOrderCoffee.getEngName(),
                                    readableOrderCoffee.getPrice(),
                                    readableOrderCoffee.getQuantity());
                    return orderCoffeeResponseDto;
                }).collect(Collectors.toList());
    }
}
