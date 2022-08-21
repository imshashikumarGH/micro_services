package com.learning.orderservice.service.serviceImpl;

import com.learning.orderservice.backendServices.ProductBackendService;
import com.learning.orderservice.dao.Impl.OrderDaoImpl;
import com.learning.orderservice.model.CalPriceResponse;
import com.learning.orderservice.model.GetPriceResponse;
import com.learning.orderservice.service.OrderService;
import javafx.scene.chart.ScatterChart;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDaoImpl orderDaoImpl;

    @Autowired
    ProductBackendService productBackendService;

    @Override
    public CalPriceResponse calculatePriceService(String itemId, int quantity) {
        log.info(">>>calculatePriceService()");
        log.info("Calling Product services to get price of item -{} ", itemId);
        try {
            ResponseEntity<GetPriceResponse> priceForProductServices = productBackendService.getPriceForItem(itemId);
            if (priceForProductServices.getStatusCode().is2xxSuccessful()) {
                int price = priceForProductServices.getBody().getPrice();
                CalPriceResponse calPriceResponse = CalPriceResponse.builder().totalPrice(price * quantity).quantity(quantity).itemId(itemId).build();
                return calPriceResponse;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("Fails to get response from Product services");

        }
        log.info("Calling Doa to get price");
        int totalPrice = orderDaoImpl.calculatePriceDao(itemId, quantity);
        log.info("<<<calculatePriceService()");
        return CalPriceResponse.builder()
                .itemId(itemId)
                .totalPrice(totalPrice)
                .quantity(quantity).build();

    }

}
