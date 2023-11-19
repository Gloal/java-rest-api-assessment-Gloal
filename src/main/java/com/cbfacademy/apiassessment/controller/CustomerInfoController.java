package com.cbfacademy.apiassessment.controller;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.exception.SymbolNotFoundException;
import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.model.InvestmentPreferences;
import com.cbfacademy.apiassessment.response.ResponseHandler;
import com.cbfacademy.apiassessment.serviceImpls.CustomerInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/customers")
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
        return ResponseHandler.responseBuilder("Created New Customer", HttpStatus.CREATED,
                customerInfoService.createCustomer(customerInfo));
    }

    /**
     * Returns Customer by Id
     * <p>
     * If successful, returns Http Status.OK and Portion of the created opbect with
     * Id
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@Valid @PathVariable String id) {
        Long idLong = Long.parseLong(id);
        return ResponseHandler.responseBuilder("Customer by ID: " + id, HttpStatus.OK,
                customerInfoService.getCustomerById(idLong));
    }

    /**
     * Updates Customer by Id
     * <p>
     * If successful, returns Http Status.NO_CONTENT -> Code: 204
     * <p>
     * If unsuccessful, returns HttpStatus.NOT FOUND -> Code: 404 or
     * IllegalArguementException if null
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerInfo customerInfo) {
        Long idLong = Long.parseLong(id);
        customerInfoService.updateCustomerInfo(idLong, customerInfo);
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

    /** Add Investment Preference to specific customer by ID 
     * @throws IOException
     * @throws SymbolNotFoundException
     * @throws JsonProcessingException
     * @throws JsonMappingException */
    @PostMapping("/{customerId}/investment-preferences")
    public ResponseEntity<Object> addInvestmentPreferences(@PathVariable String customerId,
            @RequestBody InvestmentPreferences investmentPreferences) throws JsonMappingException, JsonProcessingException, SymbolNotFoundException, IOException {
        Long idCLong = Long.parseLong(customerId);
        return ResponseHandler.responseBuilder("Investment Preferences added for Customer id: " + customerId,
                HttpStatus.CREATED,
                customerInfoService.addInvestmentPreferencesByCustomerId(idCLong, investmentPreferences));
    }



    /** Get all Investment Preferences for specific customer by ID */
    @GetMapping("/{customerId}/investment-preferences")
    public ResponseEntity<Object> getAllInvestmentPreferences(@PathVariable String customerId) {
        Long idCLong = Long.parseLong(customerId);
        return ResponseHandler.responseBuilder("All investment Preferences for Customer " + customerId,
                HttpStatus.OK, customerInfoService.getAllInvestmentPreferencesByCustomerId(idCLong));
    }



    /** Update Investment Preferences by ID for specific customer 
     * @throws IOException
     * @throws SymbolNotFoundException
     * @throws JsonProcessingException
     * @throws JsonMappingException */
    @PutMapping("/{customerId}/investment-preferences/{invPreId}")
    public ResponseEntity<Object> updateInvestmentPreferences(@PathVariable String customerId,
            @PathVariable String invPreId,
            @RequestBody InvestmentPreferences investmentPreferences) throws JsonMappingException, JsonProcessingException, SymbolNotFoundException, IOException {
        Long idCLong = Long.parseLong(customerId);
        Long idIPLong = Long.parseLong(invPreId);
        return ResponseHandler.responseBuilder(
                "Updated investment Preference " + invPreId + " for Customer " + customerId,
                HttpStatus.OK,
                customerInfoService.updateInvestmentPreference(idCLong, idIPLong, investmentPreferences));
    }

    

    /** Delete Investment Preference by Id for specific customer */
   // @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customerId}/investment-preferences/{invPreId}")
    public void deleteInvestmentPreferences(@PathVariable String customerId,
            @PathVariable String invPreId) {
        Long idCLong = Long.parseLong(customerId);
        Long idIPLong = Long.parseLong(invPreId);
        customerInfoService.deleteInvestmentPreferences(idCLong, idIPLong);
    }

}
