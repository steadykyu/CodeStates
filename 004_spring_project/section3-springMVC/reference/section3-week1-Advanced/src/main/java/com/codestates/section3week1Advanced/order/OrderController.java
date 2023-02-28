package com.codestates.section3week1Advanced.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderController {
    @PostMapping
    public ResponseEntity postOrder(HttpServletRequest httpServletRequest,
                                    @RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId){
        System.out.println("user-agent: " + httpServletRequest.getHeader("user-agent"));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public String getOrder(@PathVariable("order-id") long orderId){
        System.out.println("# orderId: "+orderId);

        // not implementation
        return null;
    }

    @GetMapping
    public String getOrders() {
        System.out.println("# get Orders");

        // not implementation
        return null;
    }
}
