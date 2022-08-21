package com.learning.productservice.service.impl;

import com.learning.productservice.dao.ProductDao;
import com.learning.productservice.model.GetPriceResponse;
import com.learning.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public GetPriceResponse getPriceForProductService(String productId) {
        log.info(">>>getPriceForProductService()");
        return productDao.getPriceForProductDao(productId);
    }
}
