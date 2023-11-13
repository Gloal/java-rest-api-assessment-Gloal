package com.cbfacademy.apiassessment.response;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//TODO: create a custom Response for the CustomerInfo with ID

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
        String message, HttpStatus httpStatus, Object responseObject){
            Map<String, Object> response = new HashMap<>();
            response.put("message", message);
            response.put("httpStatus", httpStatus);
            response.put("responseObject", responseObject.toString());

            return new ResponseEntity<>(response,httpStatus);
        }

    
}
