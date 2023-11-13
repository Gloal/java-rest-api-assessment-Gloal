package com.cbfacademy.apiassessment.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PastEarningsRepo {

    // takes in symbol

    // TODO: VALIDATE SYMBOL
    // String symbol = jsonNode.get("symbol"); if symbol=customre.getSymbol -
    // proceed - otherwise error
    // Symbol neededSymbol = CustomerInfo.getSymbol();

    // send api call
    // TODO: String getApiQueryString(String symbol, Duration duration);
    /// create Api query string

    // private File getPastEarningsFromApi(Symbol symbol) {
    // save json-file returned with specific naming format
    // read json file

    // private PastEarnings readFile(File jsonFileName)
    // get a pastearnings object


    PastEarnings pastEarnings;

    public PastEarnings getPastEarnings() throws JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Path jsonFile = Paths.get("src/main/resources/datafiles/IBM_earnings.json");

        String json = new String(Files.readAllBytes(jsonFile));
        var pastEarnings = objectMapper.readValue(json,
                PastEarnings.class);

        return pastEarnings;
    }

    public void savePastEarnings(PastEarnings pastEarnings) {
        this.pastEarnings = pastEarnings;

    }

}