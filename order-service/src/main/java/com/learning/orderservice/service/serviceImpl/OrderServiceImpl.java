package com.learning.orderservice.service.serviceImpl;

import com.learning.orderservice.backendServices.ProductBackendService;
import com.learning.orderservice.dao.Impl.OrderDaoImpl;
import com.learning.orderservice.model.CalPriceResponse;
import com.learning.orderservice.model.GetPriceResponse;
import com.learning.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDaoImpl orderDaoImpl;

    @Autowired
    ProductBackendService productBackendService;

    @Override
    public CalPriceResponse calculatePriceService(String itemId, int quantity) {
        ResponseEntity<GetPriceResponse> priceForProductServices = productBackendService.getPriceForItem(itemId);
        if (priceForProductServices.getStatusCode().is2xxSuccessful()) {
            int price = priceForProductServices.getBody().getPrice();
            CalPriceResponse calPriceResponse = CalPriceResponse.builder().totalPrice(price * quantity).quantity(quantity).itemId(itemId).build();
            return calPriceResponse;
        }
        int totalPrice = orderDaoImpl.calculatePriceDao(itemId, quantity);
        return CalPriceResponse.builder()
                .itemId(itemId)
                .totalPrice(totalPrice)
                .quantity(quantity).build();
    }

}
