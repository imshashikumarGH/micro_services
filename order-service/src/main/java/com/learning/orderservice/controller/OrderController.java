package com.learning.orderservice.controller;

import com.learning.orderservice.model.CalPriceResponse;
import com.learning.orderservice.service.serviceImpl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @GetMapping("/calculatePrice")
    public ResponseEntity<?> calculatePrice(@RequestParam("ItemId") String itemId, @RequestParam("quantity") int quantity) {
        log.info(">>>calculatePrice() : to get the total Price for {} - items of productID - {} ", quantity,itemId);
        CalPriceResponse calPriceResponse = orderServiceImpl.calculatePriceService(itemId, quantity);
        log.info("<<<calculatePrice()");
        return new ResponseEntity<>(calPriceResponse, HttpStatus.OK);
    }
}
