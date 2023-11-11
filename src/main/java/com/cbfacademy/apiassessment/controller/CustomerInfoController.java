package com.cbfacademy.apiassessment.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.response.ResponseHandler;
import com.cbfacademy.apiassessment.service.CustomerInfoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;


    public CustomerInfoController(CustomerInfoService customerInfoService) {
        this.customerInfoService = customerInfoService;
    }

    /** Returns all customers in the database */

    @GetMapping("")
    public List<CustomerInfo> getAllCustomerInfos() {
        System.out.println(customerInfoService.getAllCustomerInfos().stream().findFirst());
        return customerInfoService.getAllCustomerInfos();
    }

    /**
     * Creates New Customer
     * <p>
     * Returns HTTPStatus.CREATED -> Code 201
     */
    @PostMapping("")
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerInfo customerInfo) {
        return ResponseHandler.responseBuilder("Created Customer", HttpStatus.CREATED, customerInfoService.createCustomer(customerInfo));
    }

    /**
     * Returns Customer by Id
     * <p>
     * If successful, returns Http Status.OK and Portion of the created opbect with Id
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@Valid @PathVariable String id) {
        //TODO: WRAP THIS IN TRY CATCH TO CATCH 500 error and return 400
        //TODO: add validation see:spring - validating path variablea dna request parameners - websire: reflectoring.io
        
            Long idLong = Long.parseLong(id);
            return ResponseHandler.responseBuilder("Customers by ID", HttpStatus.OK, customerInfoService.getCustomerById(idLong));  
    }

    /**
     * Updates Customer by Id
     * <p>
     * If successful, returns Http Status.NO_CONTENT -> Code: 204
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404 or IllegalArguementException if null
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerInfo customerInfo) {
            Long idLong = Long.parseLong(id);
         customerInfoService.updateCustomerInfo(idLong, customerInfo) ;
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
        customerInfoService.deleteCustomer(idLong);
    }

}
