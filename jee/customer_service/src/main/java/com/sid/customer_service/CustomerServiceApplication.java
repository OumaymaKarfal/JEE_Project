package com.sid.customer_service;

import com.sid.customer_service.dao.CustomerRepository;
import com.sid.customer_service.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Autowired
    private RepositoryRestConfiguration restConfig;
        @Bean
        CommandLineRunner start(CustomerRepository customerRepository){
            return args -> {
                restConfig.exposeIdsFor(Customer.class);
                customerRepository.save(new Customer(null,"customer1","customer@cs.com"));
                customerRepository.save(new Customer(null,"customer2","customer1@cs.com"));
                customerRepository.save(new Customer(null,"customer3","customer2@cs.com"));
                customerRepository.save(new Customer(null,"customer4","customer3@cs.com"));
                customerRepository.findAll().forEach(
                        customer -> {
                            System.out.println(customer.toString());
                        }
                );

            };
        }
}
