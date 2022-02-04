package com.example.bookstoremicroservice.customer.adapter;

import com.example.bookstoremicroservice.customer.repository.CustomerRepository;
import com.example.customer.domain.Customer;
import com.example.customer.domain.Location;
import com.example.shared.domain.CustomerId;

import java.util.List;

public class CustomerRepositoryMongoAdapter implements CustomerRepository {

    @Override
    public List<Customer> findAllCustomers() {
        return null;
    }

    @Override
    public List<Customer> findCustomersByLocation(Location location) {
        return null;
    }

    @Override
    public Boolean exitsById(CustomerId customerId) {
        return null;
    }

    @Override
    public Customer findCustomerById(CustomerId customerId) {
        return null;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer deleteCustomer(CustomerId customerId) {
        return null;
    }
}
