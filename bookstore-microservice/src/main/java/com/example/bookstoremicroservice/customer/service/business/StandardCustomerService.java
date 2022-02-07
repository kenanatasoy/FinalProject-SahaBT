package com.example.bookstoremicroservice.customer.service.business;

import com.example.bookstoremicroservice.customer.document.CustomerDocument;
import com.example.bookstoremicroservice.customer.dto.response.CustomerResponse;
import com.example.bookstoremicroservice.customer.dto.request.CustomerRequest;
import com.example.bookstoremicroservice.customer.repository.CustomerRepository;
import com.example.bookstoremicroservice.customer.service.CustomerService;
import com.example.customer.application.CustomerApplication;
import com.example.customer.application.business.exception.CustomerNotFoundException;
import com.example.customer.domain.Customer;
import com.example.customer.domain.Location;
import com.example.shared.domain.CustomerId;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.Optional;

public class StandardCustomerService implements CustomerService {

    private CustomerApplication customerApplication;
    private ModelMapper modelMapper;

    public StandardCustomerService(CustomerApplication customerApplication, ModelMapper modelMapper) {
        this.customerApplication = customerApplication;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerApplication.getAllCustomers().stream().map(customer -> modelMapper.map(customer,CustomerResponse.class)).toList();
    }

    @Override
    public List<CustomerResponse> getCustomersByLocation(String location) {
        return customerApplication.getCustomersByLocation(Location.valueOf(location))
                                  .stream().map(customer -> modelMapper.map(customer,CustomerResponse.class)).toList();
    }

    @Override
    public Optional<CustomerResponse> getCustomerById(String customerId) {
        Optional<Customer> customer = customerApplication.getCustomerById(CustomerId.valueOf(customerId));
        if (customer.isEmpty())
            throw new CustomerNotFoundException("Customer does not exist",customerId);
        return Optional.of(modelMapper.map(customer,CustomerResponse.class));
    }

    @Override
    public Optional<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        Optional<Customer> customerOptional = customerApplication.addCustomer(customer);
        return Optional.ofNullable(modelMapper.map(customerOptional,CustomerResponse.class));
    }

    @Override
    public Optional<CustomerResponse> updateCustomer(CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest,Customer.class);
        Optional<Customer> customerOptional = customerApplication.updateCustomer(customer);
        return Optional.ofNullable(modelMapper.map(customerOptional,CustomerResponse.class));
    }

    @Override
    public Optional<CustomerResponse> deleteCustomerById(String customerId) {
        Optional<Customer> customer = customerApplication.deleteCustomerById(CustomerId.valueOf(customerId));
        return Optional.ofNullable(modelMapper.map(customer,CustomerResponse.class));
    }
}
