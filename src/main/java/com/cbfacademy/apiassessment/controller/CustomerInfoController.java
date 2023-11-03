package com.cbfacademy.apiassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.repository.CustomerCollectionRepository;

@RestController
@RequestMapping("/customer")
public class CustomerInfoController {

    @Autowired
    private final CustomerCollectionRepository customerCollectionRepository;

   //Find all customer info
   @GetMapping("")
   public List<CustomerInfo> getAllCustomerInfos(){
    return customerCollectionRepository.getAllCustomerInfos();
   }

   

}
