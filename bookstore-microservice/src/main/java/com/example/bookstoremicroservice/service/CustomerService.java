package com.example.bookstoremicroservice.service;

import com.example.bookstoremicroservice.dto.request.CustomerRequest;
import com.example.bookstoremicroservice.dto.response.CustomerResponse;
import com.example.customer.domain.Customer;
import com.example.customer.domain.Location;
import com.example.shared.domain.CustomerId;

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
