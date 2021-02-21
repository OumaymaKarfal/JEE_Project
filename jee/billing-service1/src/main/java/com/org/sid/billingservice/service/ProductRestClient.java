package com.org.sid.billingservice.service;

import com.org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping(path = "/produits")
    PagedModel<Product> pageProducts();
    @GetMapping(path = "/produits/{id}")
    Product getProductById(@PathVariable Long id);
}
