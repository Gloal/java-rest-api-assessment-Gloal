package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.h2.util.json.JSONObject;
import org.springframework.boot.CommandLineRunner;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.repository.PastEarningsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

public class DataLoaderJSON implements CommandLineRunner{

    private final PastEarningsRepository pastEarningsRepository;
    private final ObjectMapper objectMapper;

    public DataLoaderJSON (ObjectMapper objectMapper, PastEarningsRepository pastEarningsRepository){
        this.pastEarningsRepository = pastEarningsRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public String toString() {
        return "DataLoader []";
    }

    @Override
    public void run (String...args) throws Exception{
        List<PastEarnings> pastEarningsList = new ArrayList<>();
        
        JsonNode json;

        try (InputStream inputstream = TypeReference.class.getResourceAsStream("src/main/resources/datafiles/past_earnings.json")){
            objectMapper.readValue(inputstream, PastEarnings.class);
        }catch (IOException e){
            System.out.println("Failed to read json file: "+ e.getMessage());

        }
        PastEarnings pastEarnings = objectMapper.readValue("src/main/resources/datafiles/past_earnings.json", PastEarnings);
        System.out.println(pastEarnings);

        pastEarningsRepository.save(pastEarnings);



    }
}
