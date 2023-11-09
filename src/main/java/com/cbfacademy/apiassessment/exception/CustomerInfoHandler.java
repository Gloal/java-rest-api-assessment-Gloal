package com.cbfacademy.apiassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerInfoHandler {
    //add all custom exceptions you want this method to handle 
    @ExceptionHandler(value={CustomerNotFoundException.class})
    public ResponseEntity<Object> handleCustomerNotFoundException
        (CustomerNotFoundException customerNotFoundException){

            CustomerInfoException customerInfoException = 
                new CustomerInfoException(
                    customerNotFoundException.getMessage(),
                    customerNotFoundException.getCause(),
                    HttpStatus.NOT_FOUND
                );
            return new ResponseEntity<>(customerInfoException, HttpStatus.NOT_FOUND);
        }
    
}
