package com.cbfacademy.apiassessment.exception;

public class SymbolNotFoundException extends Exception{

    private static final String message = "The supplied symbol was not found in our records";

    public SymbolNotFoundException(){
        super(message);
        }

    public SymbolNotFoundException(String message,Throwable cause){
        super(message, cause);
    }

    @Override
    public String getMessage(){
        return "The supplied symbol was not found in our records";
    }
}
