package com.codestates.coffee.service;

import com.codestates.coffee.repository.CoffeeRepository;
import com.codestates.coffee.entity.Coffee;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffeeService {
    private CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee createCoffee(Coffee coffee) {
        // 커피 코드를 대문자로 변경
        String coffeeCode = coffee.getCoffeeCode().toUpperCase();

        // 이미 등록된 커피 코드인지 확인
        verifyExistCoffee(coffeeCode);
        coffee.setCoffeeCode(coffeeCode);

        return coffeeRepository.save(coffee);
    }

    public Coffee updateCoffee(Coffee coffee) {
        // 조회하려는 커피가 검증된 커피인지 확인(존재하는 커피인지 확인 등)
        Coffee findCoffee = findVerifiedCoffee(coffee.getCoffeeId());

        // TODO 리팩토링 포인트( 값을 수정해준다.)
        Optional.ofNullable(coffee.getKorName())
                .ifPresent(korName -> findCoffee.setKorName(korName));
        Optional.ofNullable(coffee.getEngName())
                .ifPresent(engName -> findCoffee.setEngName(engName));
        Optional.ofNullable(coffee.getPrice())
                .ifPresent(price -> findCoffee.setPrice(price));

        return coffeeRepository.save(findCoffee);
    }

    public Coffee findCoffee(long coffeeId) {
        return findVerifiedCoffeeByQuery(coffeeId);
    }

    // 주문에 해당하는 커피 정보 조회
    public List<Coffee> findOrderedCoffees(Order order) {
        return order.getOrderCoffees()
                .stream()
                .map(coffeeRef -> findCoffee(coffeeRef.getCoffeeId()))
                .collect(Collectors.toList());
    }

    public List<Coffee> findCoffees() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    /**
     * 주문에 해당하는 커피 정보를 한 번에 조회한다.
     * @param coffeeIds
     * @return
     */
    public List<Coffee> findAllCoffeesByIds(List<Long> coffeeIds) {
        return (List<Coffee>) coffeeRepository.findAllById(coffeeIds);
    }

    public void deleteCoffee(long coffeeId) {
        Coffee coffee = findVerifiedCoffee(coffeeId);
        coffeeRepository.delete(coffee);
    }

    // ID에 해당하는 커피가 DB에 존재하는지 확인하는 메서드
    public Coffee findVerifiedCoffee(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(coffeeId);
        Coffee findCoffee =
                optionalCoffee.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }
    // DB에 커피가 존재하는지 안하는지 확인하는 메서드
    private void verifyExistCoffee(String coffeeCode) {
        Optional<Coffee> coffee = coffeeRepository.findByCoffeeCode(coffeeCode);
        if(coffee.isPresent())
            throw new BusinessLogicException(ExceptionCode.COFFEE_CODE_EXISTS);
    }
    // 사실 findVerifiedCoffee() 로 해도 되지만,
    // Repository의 커스텀 메서드가 동작하는 모습을 보이기 위해 만든 메서드
    private Coffee findVerifiedCoffeeByQuery(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findByCoffee(coffeeId);
        Coffee findCoffee =
                optionalCoffee.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }
}
