package com.learning.orderservice.dao;

public interface OrderDao {
    int calculatePriceDao(String itemId, int quantity);
}
