package edu.iu.p565.respository;

import java.util.*;

import org.springframework.stereotype.Repository;

import edu.iu.p565.model.Customer;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();
    
    public List<Customer> findAll() {
        return customers;
    }

    // returns the id of the created customer
    public int create(Customer customer){
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }
}
