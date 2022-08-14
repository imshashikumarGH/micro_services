package com.learning.orderservice.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalPriceResponse {
    private int totalPrice;
    private int quantity;
    private String itemId;
}
