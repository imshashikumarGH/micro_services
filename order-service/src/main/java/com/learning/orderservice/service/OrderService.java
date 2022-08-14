package com.learning.orderservice.service;

import com.learning.orderservice.dao.orderDaoImpl.OrderDaoImpl;
import com.learning.orderservice.model.CalPriceResponse;
import com.learning.orderservice.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImpl {

    @Autowired
    OrderDaoImpl orderDaoImpl;

    @Override
    public CalPriceResponse calculatePriceService(String itemId, int quantity) {
        int totalPrice = orderDaoImpl.calculatePriceDao(itemId, quantity);
        return CalPriceResponse.builder()
                .itemId(itemId)
                .totalPrice(totalPrice)
                .quantity(quantity).build();
    }
}
