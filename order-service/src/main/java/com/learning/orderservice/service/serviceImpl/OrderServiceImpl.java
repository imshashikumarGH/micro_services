package com.learning.orderservice.service.serviceImpl;

import com.learning.orderservice.model.CalPriceResponse;

public interface OrderServiceImpl {

    CalPriceResponse calculatePriceService(String itemId, int quantity);
}
