package com.learning.productservice.controller;

import com.learning.productservice.model.GetPriceResponse;
import com.learning.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getPrice/{productId}")
    public ResponseEntity<GetPriceResponse> getPrice(@PathVariable("productId") String productId) {
        GetPriceResponse getPriceResponse = productService.getPriceForProductService(productId);
        return new ResponseEntity<>(getPriceResponse, HttpStatus.OK);
    }
}
