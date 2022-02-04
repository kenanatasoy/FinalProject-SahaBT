package com.example.bookstoremicroservice.customer.service;

import com.example.bookstoremicroservice.customer.dto.request.CustomerRequest;
import com.example.bookstoremicroservice.customer.dto.response.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerResponse> getAllCustomers();
    List<CustomerResponse> getCustomersByLocation(String location);
    Optional<CustomerResponse> getCustomerById(String customerId);
    Optional<CustomerResponse> addCustomer(CustomerRequest customerRequest);
    Optional<CustomerResponse> updateCustomer(CustomerRequest customerRequest);
    Optional<CustomerResponse> deleteCustomerById(String customerId);

}
