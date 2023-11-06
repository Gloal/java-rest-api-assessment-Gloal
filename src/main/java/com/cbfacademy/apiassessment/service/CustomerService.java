package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exception.ResourceNotFoundException;
import com.cbfacademy.apiassessment.model.Customer;
import com.cbfacademy.apiassessment.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface    {

    @Autowired(required=true)
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(UUID id) {
        Optional <Customer> customerInDb = customerRepository.findById(id);
        if(customerInDb.isPresent()){
            Customer customer = customerInDb.get();
            return customer;
        }else{
            throw new ResourceNotFoundException("Cannot find this customer in the Database: ID "+id+" is wrong");
        }
    }

    @Override
    public Customer updateCustomer(UUID id, Customer customer) {

        Optional <Customer> customerInDb = customerRepository.findById(id);
        if(customerInDb.isPresent()){
            Customer customerToUpdate = customerInDb.get();
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setLastName(customer.getLastName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setInvestmentPreferences(customer.getInvestmentPreferences());
            return customerRepository.save(customerToUpdate);
        }else {
            throw new ResourceNotFoundException("Cannot find this customer in the Database: ID "+customer.getId()+" is wrong");
        }
    }

}
