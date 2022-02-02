package com.example.customer.application;

import com.example.customer.domain.Customer;
import com.example.customer.domain.Identity;
import com.example.customer.domain.Location;

import java.util.List;
import java.util.Optional;

public interface CustomerApplication {

    List<Customer> getAllCustomers();
    List<Customer> getCustomersByLocation(Location location);
    Optional<Customer> getCustomerById(Identity identity);
    Optional<Customer> addCustomer(Customer customer);
    Optional<Customer> updateCustomer(Customer customer);
    Optional<Customer> deleteCustomer(Identity identity);

}
