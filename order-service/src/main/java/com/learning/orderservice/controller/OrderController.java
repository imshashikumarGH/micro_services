package com.learning.orderservice.controller;

import com.learning.orderservice.model.CalPriceResponse;
import com.learning.orderservice.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @GetMapping("/calculatePrice")
    public ResponseEntity<?> calculatePrice(@RequestParam("ItemId") String itemId, @RequestParam("quantity") int quantity) {
        CalPriceResponse calPriceResponse = orderServiceImpl.calculatePriceService(itemId, quantity);
        return new ResponseEntity<>(calPriceResponse, HttpStatus.OK);

    }
}
