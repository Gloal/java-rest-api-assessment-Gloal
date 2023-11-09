package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exception.CustomerNotFoundException;
import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.repository.CustomerCollectionRepository;

@Configuration
@Service
public class CustomerInfoService implements CustomerInfoServiceInterface {

    @Autowired
    private CustomerCollectionRepository customerCollectionRepository;

    /* 
    private static final Logger log = LoggerFactory.getLogger(CustomerInfoService.class);

    

    Put some dummy values in the database to start
    @Bean
    CommandLineRunner initDatabase(CustomerCollectionRepository customerCollectionRepository){
        return args -> {
            log.info("Loading "+customerCollectionRepository.save(new CustomerInfo("nameRepo", "repos", "hfeu@nie.com")));
        };
    }
    */

    @Override
    public void deleteCustomer(Long id) {
        customerCollectionRepository.deleteById(id);
    }

    @Override
    public List<CustomerInfo> getAllCustomerInfos() {
        return customerCollectionRepository.findAll();
    }

    @Override
    public CustomerInfo getCustomerById(Long id) {
        if (customerCollectionRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerCollectionRepository.findById(id).get();
        }

    @Override
    public CustomerInfo createCustomer(CustomerInfo customerInfo) {
        return customerCollectionRepository.save(customerInfo);
    }

    @Override
    public void updateCustomerInfo(Long id, CustomerInfo customerInfo) {
        
        CustomerInfo customerToUpdate = getCustomerById(id).orElseThrow();
            customerToUpdate.setFirstName(customerInfo.getFirstName());
            customerToUpdate.setFirstName(customerInfo.getFirstName());
            customerToUpdate.setEmail(customerInfo.getEmail());
            customerCollectionRepository.save(customerToUpdate);
        }
    }


   /*  
public List<CustomerInfo> getAllCustomerInfos(){
    return customerInfoList;
}

public CustomerInfo createCustomerInfo(CustomerInfo customerInfo){
    customerInfoList.add(customerInfo);
    return customerInfo;
}

public Optional<CustomerInfo> getCustomerById(Long id){
    return customerInfoList.stream().filter(c -> c.id().equals(id)).findFirst();
}

public boolean existsById(Long id){
    return customerInfoList.stream().filter(c -> c.id().equals(id)).count() ==1;
}


public void updateCustomerInfo(Long id, CustomerInfo customerInfo) {
        customerInfoList.removeIf(c -> c.id().equals(customerInfo.id()));
        customerInfoList.add(customerInfo);
}

public void deleteCustomer(Long id){
    customerInfoList.removeIf(c -> c.id().equals(id));
}
 */