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

    private Customer getCustomerById(int id){
        return customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void update(Customer customer, int id){
        Customer x = getCustomerById(id);
        if(x != null){
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        } else {
            throw new IllegalStateException("customer with this id wasn't found");
        }
    }

    public void delete(int id){
        Customer x = getCustomerById(id);
        if(x != null){
            customers.remove(x);
        } else {
            throw new IllegalStateException("customer with this id wasn't found");
        }
    }
}
