package com.cbfacademy.apiassessment.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{


            //FIND OUT THE POINT OF THIS!!
            public static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);

    }
    
}
