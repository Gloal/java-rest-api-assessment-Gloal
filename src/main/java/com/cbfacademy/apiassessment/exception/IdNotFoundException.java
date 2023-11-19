package com.cbfacademy.apiassessment.exception;


public class IdNotFoundException extends RuntimeException{

    private static final String message = "Customer with supplied id does not exist";

    public IdNotFoundException(){
        super(message);
        }

    public IdNotFoundException(String message,Throwable cause){
        super(message, cause);
    }

    @Override
    public String getMessage(){
        return "Customer with supplied id does not exist";
    }

}
