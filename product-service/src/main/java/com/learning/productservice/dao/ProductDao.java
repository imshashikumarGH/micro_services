package com.learning.productservice.dao;

import com.learning.productservice.model.GetPriceResponse;

public interface ProductDao {
    GetPriceResponse getPriceForProductDao(String productId);

}
