package com.cbfacademy.apiassessment.service;

import java.util.List;

import com.cbfacademy.apiassessment.model.CustomerInfo;

public interface CustomerInfoServiceInterface {

    public CustomerInfo createCustomer(CustomerInfo customerInfo);
    void deleteCustomer(Long id);
    List<CustomerInfo> getAllCustomerInfos();
    public CustomerInfo getCustomerById(Long id);
    void updateCustomerInfo(Long id, CustomerInfo customerInfo);
}
