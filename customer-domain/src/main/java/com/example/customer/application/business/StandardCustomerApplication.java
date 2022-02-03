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
        //TODO: Optional'ın of, ofNullable ve empty metotları hocaya sorulacak
        // Employee domain class'ı sorulacak hocaya
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
//        TODO: fields that could be updated are below, identity, age and fullname cannot be updated;
//        private Location location;
//        private List<Interest> interests;
//        private Email email;
//        private Epurse epurse;
//        private Username userName;
//        private Password password;
//        private IsAdmin isAdmin;

        return Optional.ofNullable(customerRepository.updateCustomer(customer));
    }

    @Override
    public Optional<Customer> deleteCustomer(CustomerId customerId) {
        return Optional.ofNullable(customerRepository.deleteCustomer(customerId));
    }



}
