package com.codestates.coffee;

import com.codestates.member.NotSpace;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.util.Optional;


@Getter
@Setter
public class CoffeePatchDto {
    @NotSpace
    private String korName;

    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "ddd")
    private String engName;
    private long coffeeId;

    @CorrectPrice
    private int price;
    // 아무것도 요청하지 않으면, 그냥 기본값인 0이 들어가있는다.
//    private Optional<@Range(min=100, max= 50000) Integer> price = Optional.empty();
}
