package com.learning.orderservice.dao.Impl;

import com.learning.orderservice.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OrderDaoImpl implements OrderDao {

    @Override
    public int calculatePriceDao(String itemId, int quantity) {
        log.info(">>>calculatePriceDao()");
        return quantity * 10;
    }
}
