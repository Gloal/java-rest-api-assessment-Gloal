package com.cbfacademy.apiassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Customer id supplied does not exist in the database")
public class CustomerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    //TODO: CHANGE TO THIS MESSAGE
   /*  
   CustomerNotFoundException(Long id){
        super("Could not find customer with id: "+id+" in database.");
    }

    in the controller class it is called as follows:

    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EmployeeNotFoundException ex) {
      return ex.getMessage();
    } 
    */
}
