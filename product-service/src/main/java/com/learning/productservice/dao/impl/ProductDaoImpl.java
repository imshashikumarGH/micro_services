package com.learning.productservice.dao.impl;

import com.learning.productservice.dao.ProductDao;
import com.learning.productservice.model.Configuration;
import com.learning.productservice.model.GetPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    Configuration configuration;

    @Override
    public GetPriceResponse getPriceForProduct(String productId) {
        return GetPriceResponse.builder().price(100).productId(productId).discount(configuration.getDiscount()).build();
    }
}
