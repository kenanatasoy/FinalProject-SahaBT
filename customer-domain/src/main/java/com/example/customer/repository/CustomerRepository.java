package com.example.customer.repository;

import com.example.customer.domain.Customer;
import com.example.customer.domain.Identity;
import com.example.customer.domain.Location;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAllCustomers();
    List<Customer> findCustomersByLocation(Location location);
    Boolean exitsById(Identity identity);
    Customer findCustomerById(Identity identity);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Identity identity);




}
