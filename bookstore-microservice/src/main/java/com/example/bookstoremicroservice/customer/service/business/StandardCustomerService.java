package com.example.bookstoremicroservice.customer.service.business;

import com.example.bookstoremicroservice.customer.dto.response.CustomerResponse;
import com.example.bookstoremicroservice.customer.dto.request.CustomerRequest;
import com.example.bookstoremicroservice.customer.service.CustomerService;
import com.example.customer.application.CustomerApplication;


import java.util.List;
import java.util.Optional;

public class StandardCustomerService implements CustomerService {

    private CustomerApplication customerApplication;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return null;
    }

    @Override
    public List<CustomerResponse> getCustomersByLocation(String location) {
        return null;
    }

    @Override
    public Optional<CustomerResponse> getCustomerById(String customerId) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResponse> updateCustomer(CustomerRequest customerRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResponse> deleteCustomerById(String customerId) {
        return Optional.empty();
    }
}
