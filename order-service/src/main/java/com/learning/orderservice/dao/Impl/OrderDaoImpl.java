package com.learning.orderservice.dao.Impl;

import com.learning.orderservice.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public int calculatePriceDao(String itemId, int quantity) {
        return quantity * 10;
    }
}
