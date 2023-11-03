package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.Optional;

import com.cbfacademy.apiassessment.model.CustomerInfo;

public interface CustomerInfoServiceInterface {

    void deleteCustomer(Long id);
    List<CustomerInfo> getAllCustomerInfos();
    public Optional<CustomerInfo> getCustomerById(Long id);
    public CustomerInfo saveCustomer(CustomerInfo customerInfo);
    CustomerInfo updateCustomerInfo(Long id, CustomerInfo customerInfo);
}
