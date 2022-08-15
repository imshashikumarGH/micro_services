package com.learning.productservice.controller;

import com.learning.productservice.model.GetPriceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/getPrice/{productId}")
    public ResponseEntity<GetPriceResponse> getPrice(@PathVariable("productId") String productId) {
        GetPriceResponse getPriceResponse = GetPriceResponse.builder().price(100).productId(productId).build();
        return new ResponseEntity<>(getPriceResponse, HttpStatus.OK);
    }
}
