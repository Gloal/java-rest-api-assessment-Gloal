package com.cbfacademy.apiassessment.exception;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerInfoHandler {
    
     @ExceptionHandler(value={IdNotFoundException.class})
     public ResponseEntity<Object> handleIdNotFoundExceptions(IdNotFoundException IdNotFoundException){

            CustomerInfoException customerInfoException = 
                new CustomerInfoException(
                    IdNotFoundException.getMessage(),
                    IdNotFoundException.getCause(), 
                    HttpStatus.NOT_FOUND );
            return new ResponseEntity<>(customerInfoException, HttpStatus.NOT_FOUND);
     }

     
     @ExceptionHandler(value={SymbolNotFoundException.class})
     public ResponseEntity<Object> handleSymbolNotFoundExceptions(SymbolNotFoundException symbolNotFoundException){
            CustomerInfoException customerInfoException = 
                new CustomerInfoException(
                    symbolNotFoundException.getMessage(),
                    symbolNotFoundException.getCause(), 
                    HttpStatus.NOT_FOUND );
            return new ResponseEntity<>(customerInfoException, HttpStatus.NOT_FOUND);
     }




    @ExceptionHandler({NullPointerException.class, NumberFormatException.class})
    public ResponseEntity<Object> handleExceptions(Exception ex){

        if (ex instanceof NullPointerException) {
            NullPointerException nullPointerException = 
                new NullPointerException("Id cannot be null");
                return new ResponseEntity<>(nullPointerException, HttpStatus.UNPROCESSABLE_ENTITY);

        }else if (ex instanceof NumberFormatException){
    
               return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Id must be a whole number, Please enter a valid id");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
        
