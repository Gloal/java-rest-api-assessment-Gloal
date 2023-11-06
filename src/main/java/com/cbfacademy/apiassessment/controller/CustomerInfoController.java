package com.cbfacademy.apiassessment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.exception.CustomerNotFoundException;
import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.repository.CustomerCollectionRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerInfoController {

    private final CustomerCollectionRepository customerCollectionRepository;

    public CustomerInfoController(CustomerCollectionRepository repository) {
        this.customerCollectionRepository = repository;
    }

    /** Rertuns all customers in the database */
    @GetMapping("")
    public List<CustomerInfo> getAllCustomerInfos() {
        return customerCollectionRepository.getAllCustomerInfos();
    }

    /**
     * Creates New Customer
     * <p>
     * Returns HTTPStatus.CREATED -> Code 201
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public CustomerInfo createCustomer(@Valid @RequestBody CustomerInfo customerInfo) {
        return customerCollectionRepository.createCustomerInfo(customerInfo);
    }

    /**
     * Returns Customer by Id
     * <p>
     * If successful, returns Http Status.OK -> Code: 200
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CustomerInfo getCustomerById(@PathVariable String id) {
        Long idLong = Long.parseLong(id);
        return customerCollectionRepository.getCustomerById(idLong)
                .orElseThrow(() -> new CustomerNotFoundException());
    }

    /**
     * Updates Customer by Id
     * <p>
     * If successful, returns Http Status.NO_CONTENT -> Code: 204
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerInfo customerInfo) {
        if (!customerCollectionRepository.existsById(customerInfo.id())) {
            throw new CustomerNotFoundException();
        }
        // Long idLong = Long.parseLong(id);
        customerCollectionRepository.updateCustomerInfo(customerInfo.id(), customerInfo);
    }

    /**
     * Deletes Customer by Id
     * <p>
     * If successful, returns Http Status.NO_CONTENT -> Code: 204
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@Valid @PathVariable String id) {
        Long idLong = Long.parseLong(id);
        if (!customerCollectionRepository.existsById(idLong)) {
            throw new CustomerNotFoundException();
        }
        customerCollectionRepository.deleteCustomer(idLong);
    }

}
