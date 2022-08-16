package com.learning.productservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("product-service")
@Getter
@Setter
public class Configuration {
    private int discount;
}
