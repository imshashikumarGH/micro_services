package com.learning.productservice.service;

import com.learning.productservice.model.GetPriceResponse;

public interface ProductService {
    GetPriceResponse getPriceForProductService(String productId);
}
