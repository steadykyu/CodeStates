package com.codestates.section3week1Advanced.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("korName") String korName,
                                     @RequestParam("engName") String engName,
                                     @RequestParam("price") int price) {
        Map<String, Object> map = new HashMap<>();
        map.put("korName", korName);
        map.put("engName", engName);
        map.put("price", price);

        return new ResponseEntity<Map>(map, HttpStatus.CREATED);
    }
    //
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                      @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);
        coffeePatchDto.setPrice(6000);

        return new ResponseEntity(coffeePatchDto, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);

        // not implementation

        return new ResponseEntity<Map>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

        // not implementation

        return new ResponseEntity<Map>(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // No need business logic

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

// 레거시 코드
//    @PostMapping
//    public String postCoffee(@RequestParam("engName") String engName,
//                             @RequestParam("korName") String korName,
//                             @RequestParam("price") String price) {
//        System.out.println("# engName: " + engName);
//        System.out.println("# korName: " + korName);
//        System.out.println("# price: " + price);
//
//        String response =
//                "{\"" +
//                        "engName\":" + engName + "\"" +
//                        "\"korName\":\"" + korName + "\",\"" +
//                        "price\":\"" + price +
//                        "\"}";
//        return response;
//    }
//    @GetMapping("/{coffee-id}")
//    public String getCoffee(@PathVariable("coffee-id") long coffeeId){
//
//        return coffeeId + "번 커피를 가져왔습니다.";
//    }
//    @GetMapping
//    public String getCoffees(){
//
//        return "모든 커피를 가져왔습니다.";
//    }