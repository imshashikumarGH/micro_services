package com.learning.productservice.dao.impl;

import com.learning.productservice.dao.ProductDao;
import com.learning.productservice.model.Configuration;
import com.learning.productservice.model.GetPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ProductDaoImpl implements ProductDao {

    @Autowired
    Configuration configuration;

    @Override
    public GetPriceResponse getPriceForProductDao(String productId) {
        log.info(">>>getPriceForProductDao()");
        return GetPriceResponse.builder().price(100).productId(productId).discount(configuration.getDiscount()).build();
    }
}
