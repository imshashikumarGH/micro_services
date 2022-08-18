package com.learning.orderservice.service;

import com.learning.orderservice.model.CalPriceResponse;


public interface OrderService {
    CalPriceResponse calculatePriceService(String itemId, int quantity);
}
