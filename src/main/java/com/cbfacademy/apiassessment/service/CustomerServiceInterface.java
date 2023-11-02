package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.model.Customer;

public interface CustomerServiceInterface {

    Customer createCustomer(Customer customer);
    void deleteCustomer(UUID id);
    List<Customer> getAllCustomers();
    Customer getCustomerById(UUID id);
    Customer updateCustomer(UUID id, Customer customer);
}
