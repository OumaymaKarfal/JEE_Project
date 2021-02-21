package com.sid.customer_service.dao;

import com.sid.customer_service.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping(path = "/test")
    List<Customer> getcustomers(@RequestParam(name = "keyword") String mc){
      return   customerRepository.findByNameContains(mc);
    }
}
