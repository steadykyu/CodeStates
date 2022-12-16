package com.codestates.coffee;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CoffeePostDto {
    @NotBlank(message = "공백만으로 구성할 수 없습니다.")
    private String korName;
    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "공백은 하나이상 들어갈 수 없습니다.")
    private String engName;
    @Min(100)
    @Max(50000)
    private int price;
}
