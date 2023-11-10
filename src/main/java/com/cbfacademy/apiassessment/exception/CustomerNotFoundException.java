package com.cbfacademy.apiassessment.exception;

//TODO: Create ANOTHER EXCEPTION FOR ITEMS THAT ARE NOT VALID LONG DATAYPES
//TODO: EXCEPTION FOR DATA TYPES THAT RETURN HTTP:STATUS_CODE 500 - INTERNAL SERVER ERROR

public class CustomerNotFoundException extends RuntimeException{

    private static final String message = "Customer with supplied id does not exist";

    public CustomerNotFoundException(){
        super(message);
        }

    public CustomerNotFoundException(Throwable cause){
        super(message, cause);
    }

    @Override
    public String getMessage(){
        return "Customer with supplied id does not exist";
    }

}
