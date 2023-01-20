package com.codestates.section3week1.coffee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {
    @PostMapping
    public String postCoffee(@RequestParam String engName,
                      @RequestParam String korName,
                      @RequestParam long price){
        System.out.println("# engName : " + engName); // 서버 콘솔에 출력용
        System.out.println("# korName : " + korName);
        System.out.println("# price : " + price);
        // "email":"email값",
        String response = "\"engName\":\""+engName+"\","
                        + "\"korName\":\""+korName+"\","
                        + "\"price\":\""+price+"\"";
        return response;
    }
    @GetMapping("/{coffee-id}")
    public String getCoffee(@PathVariable("coffee-id") long coffeeId){

        return coffeeId + "번 커피를 가져왔습니다.";
    }
    @GetMapping
    public String getCoffees(){

        return "모든 커피를 가져왔습니다.";
    }
}
