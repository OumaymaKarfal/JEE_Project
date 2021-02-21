package com.sid.customer_service.dao;

import com.sid.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByNameContains(String mc);
}
