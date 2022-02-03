package com.example.bookstoremicroservice.service.business;

import com.example.bookstoremicroservice.dto.request.CustomerRequest;
import com.example.bookstoremicroservice.dto.response.CustomerResponse;
import com.example.bookstoremicroservice.service.CustomerService;
import com.example.customer.application.CustomerApplication;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class StandardCustomerService implements CustomerService {

    private CustomerApplication customerApplication;
    private ModelMapper modelMapper;

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
