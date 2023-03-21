package edu.iu.p565.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.p565.model.Customer;
import edu.iu.p565.respository.CustomerRepository;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@RequestBody Customer customer) {
        return repository.create(customer);
    }
}
