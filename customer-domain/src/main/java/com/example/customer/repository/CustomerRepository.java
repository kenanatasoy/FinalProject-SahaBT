package com.example.customer.repository;

import com.example.customer.domain.Customer;
import com.example.customer.domain.Location;
import com.example.shared.domain.CustomerId;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAllCustomers();
    List<Customer> findCustomersByLocation(Location location);
    Boolean exitsById(CustomerId customerId);
    Customer findCustomerById(CustomerId customerId);
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(CustomerId customerId);


}
