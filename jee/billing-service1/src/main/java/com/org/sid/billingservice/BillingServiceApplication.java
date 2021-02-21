package com.org.sid.billingservice;

import com.org.sid.billingservice.entities.Bill;
import com.org.sid.billingservice.entities.ProductItem;
import com.org.sid.billingservice.model.Customer;
import com.org.sid.billingservice.model.Product;
import com.org.sid.billingservice.repository.BillRepository;
import com.org.sid.billingservice.repository.ProductItemRepository;
import com.org.sid.billingservice.service.CustomerRestClient;
import com.org.sid.billingservice.service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRestClient customerRestClient, ProductRestClient productRestClient, BillRepository billRepository,
                            ProductItemRepository productItemRepository) {
        return args -> {
            Customer customer = customerRestClient.getCustomer(1L);
            Bill bill = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
            PagedModel<Product> products = productRestClient.pageProducts();
            products.forEach(p -> {
                        ProductItem productItem = new ProductItem();
                        productItem.setPrice(p.getPrice());
                        productItem.setQuantity(1+new Random().nextInt(100));
                        productItem.setProductId(p.getId());
                        productItem.setBill(bill);
                        productItemRepository.save(productItem);
                    }
            );
        };
    }
}
