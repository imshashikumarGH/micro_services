package com.learning.productservice.service.impl;

import com.learning.productservice.model.GetPriceResponse;
import com.learning.productservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public GetPriceResponse getPriceForProductService(String productId) {
        return GetPriceResponse.builder().price(100).productId(productId).build();
    }
}
