package com.example.customer.application.business;

import com.example.customer.application.CustomerApplication;
import com.example.customer.application.business.exception.CustomerNotFoundException;
import com.example.customer.application.business.exception.ExistingCustomerException;
import com.example.customer.domain.*;
import com.example.customer.repository.CustomerRepository;
import com.example.shared.domain.CustomerId;

import java.util.List;
import java.util.Optional;

public class StandardCustomerApplication implements CustomerApplication {

    private CustomerRepository customerRepository;

    public StandardCustomerApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Override
    public List<Customer> getCustomersByLocation(Location location) {
        return customerRepository.findCustomersByLocation(location);
    }

    @Override
    public Optional<Customer> getCustomerById(CustomerId customerId) {
        if(!customerRepository.exitsById(customerId)){
            throw new CustomerNotFoundException("Customer not found exception", customerId.getValue());
        }
        return Optional.of(customerRepository.findCustomerById(customerId));
    }

    @Override
    public Optional<Customer> addCustomer(Customer customer) {
        if(customerRepository.exitsById(customer.getIdentity())){
            throw new ExistingCustomerException("Customer not found exception", customer.getIdentity().getValue());
        }
        return Optional.ofNullable(customerRepository.saveCustomer(customer));
    }

    @Override
    public Optional<Customer> updateCustomer(Customer customer) {
        var customerToUpdate = customerRepository.findCustomerById(customer.getIdentity());
        return Optional.ofNullable(customerRepository.updateCustomer(customer));
    }

    @Override
    public Optional<Customer> deleteCustomerById(CustomerId customerId) {
        if(!customerRepository.exitsById(customerId)){
            throw new CustomerNotFoundException("Customer has already deleted", customerId.getValue());
        }
        return Optional.of(customerRepository.deleteCustomer(customerId));
    }




}
