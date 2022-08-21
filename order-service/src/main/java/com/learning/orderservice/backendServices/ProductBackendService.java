package com.learning.orderservice.backendServices;

import com.learning.orderservice.model.GetPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "product-servies", url = "localhost:8081")
// required with if naming server not present
// Issue - load balancing is not possible because of hard coded value of url
// Solution - naming server (does load balancing automatically)
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductBackendService {

    @GetMapping(value = "/product/getPrice/{productId}")
    ResponseEntity<GetPriceResponse> getPriceForItem(@PathVariable("productId") String productId);
}
