package com.cbfacademy.apiassessment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.CustomerInfo;

@Repository
public class CustomerCollectionRepository {
    
    private final List<CustomerInfo> customerInfoList = new ArrayList<>();

    public CustomerCollectionRepository(){};

    public List<CustomerInfo> getAllCustomerInfos(){
        return customerInfoList;
    }

    public CustomerInfo creaCustomerInfo(CustomerInfo customerInfo){
        return customerInfo;
    }

    public Optional<CustomerInfo> getCustomerById(Long id){
        return customerInfoList.stream().filter(c -> c.id().equals(id)).findFirst();
    }
    
}
