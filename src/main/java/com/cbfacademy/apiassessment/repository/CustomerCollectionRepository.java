package com.cbfacademy.apiassessment.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.directory.NoSuchAttributeException;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.controller.Customer;
import com.cbfacademy.apiassessment.controller.ResponseEntity;
import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.model.Duration;
import com.cbfacademy.apiassessment.model.Goal;
import com.cbfacademy.apiassessment.model.RiskLevel;
import com.cbfacademy.apiassessment.model.StockSymbol;

import jakarta.annotation.PostConstruct;

@Repository
public class CustomerCollectionRepository {

    private final List<CustomerInfo> customerInfoList = new ArrayList<>();

    public CustomerCollectionRepository(){};

    public List<CustomerInfo> getAllCustomerInfos(){
        return customerInfoList;
    }

    public CustomerInfo createCustomerInfo(CustomerInfo customerInfo){
        return customerInfo;
    }

    public Optional<CustomerInfo> getCustomerById(Long id){
        return customerInfoList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public CustomerInfo updateCustomerInfo(Long id, CustomerInfo customerInfo) {

        return customerInfo;
    }
 
    public void deleteCustomer(Long id){
        customerInfoList.remove(customerInfoList.stream().filter(c -> c.id().equals(id)).findFirst());
    }

    @PostConstruct
    private void init(){
        CustomerInfo ci = new CustomerInfo(
            5L, 
            "name1", 
            "name1", 
            "name1@here.com", 
            Goal.RETIREMENT, 
            RiskLevel.LOW, 
            Duration.FIVE_YEARS, 
            StockSymbol.AAA, 
            LocalDateTime.now(), 
            LocalDateTime.now(), 
            "htf");

        customerInfoList.add(ci);
    }
    
}
