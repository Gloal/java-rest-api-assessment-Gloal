package com.cbfacademy.apiassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Customer does not exist in database")
public class CustomerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

}
