package com.cbfacademy.apiassessment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.model.Customer;
import com.cbfacademy.apiassessment.service.CustomerService;

@RestController

public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.createCustomer(customer));

    }    
    
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id){
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    } 

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.updateCustomer(id, customer));
    } 

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id){
         customerService.deleteCustomer(id);
    } 
    




}