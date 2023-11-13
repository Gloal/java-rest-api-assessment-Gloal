package com.cbfacademy.apiassessment.serviceImpls;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
