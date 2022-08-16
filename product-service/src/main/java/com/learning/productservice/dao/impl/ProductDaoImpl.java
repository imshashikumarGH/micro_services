package com.learning.productservice.dao.impl;

import com.learning.productservice.dao.ProductDao;
import com.learning.productservice.model.GetPriceResponse;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Override
    public GetPriceResponse getPriceForProduct(String productId) {
        return GetPriceResponse.builder().price(100).productId(productId).build();
    }
}
