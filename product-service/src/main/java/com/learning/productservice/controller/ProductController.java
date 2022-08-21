package com.learning.productservice.controller;

import com.learning.productservice.model.GetPriceResponse;
import com.learning.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getPrice/{productId}")
    public ResponseEntity<GetPriceResponse> getPrice(@PathVariable("productId") String productId) {
        log.info(">>>getPrice() get price for on productId - {} ", productId);
        GetPriceResponse getPriceResponse = productService.getPriceForProductService(productId);
        log.info("<<<getPrice()");
        return new ResponseEntity<>(getPriceResponse, HttpStatus.OK);
    }
}
