package com.cbfacademy.apiassessment.service.RecommendationService;

import java.io.IOException;
import java.util.List;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.repository.PastEarningsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PastEarningsService implements PastEarningsServiceInterface{

    PastEarningsRepository pastEarningsRepository;

    public PastEarningsService(PastEarningsRepository pastEarningsRepository){
        this.pastEarningsRepository = pastEarningsRepository;
    }

    @Override
    public Iterable<PastEarnings> getAllPastEarnings() {

                return pastEarningsRepository.findAll();   }

    @Override
    public PastEarnings save(PastEarnings pastEarning) {
            return pastEarningsRepository.save(pastEarning);
    }

    @Override
    public Iterable<PastEarnings> saveAll(List<PastEarnings> pastEarningsList) {
        return pastEarningsRepository.saveAll(pastEarningsList);
    }
    
    @Override
    public void addToDatabase(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

    }

    @Override
    public Iterable<PastEarnings> getPastFiveYearsEarnings() {
    //TODO: get past data from 5 yrs ago pastEarnings.annualEarnings.fiscaldateending
    //enter date range then query date field
        throw new UnsupportedOperationException("Unimplemented method 'getPastFiveYearsEarnings'");
    }

    @Override
    public Iterable<PastEarnings> getPastFiveYearsQuarterlyEarnings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPastFiveYearsQuarterlyEarnings'");
    }
}
