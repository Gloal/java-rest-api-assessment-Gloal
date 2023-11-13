package com.cbfacademy.apiassessment.serviceImpls;

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
import com.cbfacademy.apiassessment.service.CustomerInfoServiceInterface;

@Configuration
@Service
public class CustomerInfoService implements CustomerInfoServiceInterface {

    @Autowired
    private CustomerCollectionRepository customerCollectionRepository;

    @Override
    public void deleteCustomer(Long id) {
        if (customerCollectionRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        customerCollectionRepository.deleteById(id);
    }

    @Override
    public List<CustomerInfo> getAllCustomerInfos() {
        return customerCollectionRepository.findAll();
    }

    @Override
    public CustomerInfo getCustomerById(Long id) {
        if (customerCollectionRepository.findById(id).isEmpty() || id==null){
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
        if (customerCollectionRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        CustomerInfo customerToUpdate = getCustomerById(id);
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