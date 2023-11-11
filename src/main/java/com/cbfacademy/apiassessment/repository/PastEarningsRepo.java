package com.cbfacademy.apiassessment.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import com.cbfacademy.apiassessment.model.PastEarnings;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PastEarningsRepo {

        //takes in symbol


        //send api call
    
    

    // TODO: VALIDATE SYMBOL
    // String symbol = jsonNode.get("symbol"); if symbol=customre.getSymbol -
    // proceed - otherwise error
    // Symbol neededSymbol = CustomerInfo.getSymbol();

        //save json-file
        //read json file
        //get a pastearnings object


            ObjectMapper objectMapper = new ObjectMapper();


//TODO: turn into method that takes a file name
    public static void main(String[] args) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.registerModule(new JavaTimeModule());

        Path jsonFile = Paths.get("src/main/resources/datafiles/IBM_earnings.json");

        String json = new String(Files.readAllBytes(jsonFile));
        var pastEarnings = objectMapper.readValue(json, PastEarnings.class);
        System.out.println(pastEarnings.getAnnualEarnings().stream().findFirst().get().getreportedEPS());
    }
    
}
