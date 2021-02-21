package com.org.sid.billingservice.web;

import com.org.sid.billingservice.entities.Bill;
import com.org.sid.billingservice.model.Customer;
import com.org.sid.billingservice.model.Product;
import com.org.sid.billingservice.repository.BillRepository;
import com.org.sid.billingservice.repository.ProductItemRepository;
import com.org.sid.billingservice.service.CustomerRestClient;
import com.org.sid.billingservice.service.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    public BillingRestController(CustomerRestClient customerRestClient, ProductRestClient productRestClient, BillRepository billRepository, ProductItemRepository productItemRepository) {
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
    }
    @GetMapping(path = "/fullBill/{id}")
    Bill getBill(@PathVariable Long id){
        Bill bill= billRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomer(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(p->{
            Product product=productRestClient.getProductById(p.getId());
            p.setProduct(product);
        });
        return bill;
    }
}
