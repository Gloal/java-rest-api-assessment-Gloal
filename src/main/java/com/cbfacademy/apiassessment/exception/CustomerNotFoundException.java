package com.cbfacademy.apiassessment.exception;

//TODO: Create ANOTHER EXCEPTION FOR ITEMS THAT ARE NOT VALID LONG DATAYPES

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
