package com.example.customer.application;

import com.example.customer.domain.Customer;
import com.example.customer.domain.Location;
import com.example.shared.domain.CustomerId;

import java.util.List;
import java.util.Optional;

public interface CustomerApplication {

    List<Customer> getAllCustomers();
    //TODO: pagination ile getirilir
    List<Customer> getCustomersByLocation(Location location);
    Optional<Customer> getCustomerById(CustomerId customerId);
    Optional<Customer> addCustomer(Customer customer);
    Optional<Customer> updateCustomer(Customer customer);
    Optional<Customer> deleteCustomerById(CustomerId customerId);

}
