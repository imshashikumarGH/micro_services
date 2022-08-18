package com.learning.orderservice.model;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetPriceResponse {
    private String productId;
    private int price;
    private int discount;
}
