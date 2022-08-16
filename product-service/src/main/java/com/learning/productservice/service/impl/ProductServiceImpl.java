package com.learning.productservice.service.impl;

import com.learning.productservice.dao.ProductDao;
import com.learning.productservice.model.GetPriceResponse;
import com.learning.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public GetPriceResponse getPriceForProductService(String productId) {
        return productDao.getPriceForProduct(productId);
    }
}
