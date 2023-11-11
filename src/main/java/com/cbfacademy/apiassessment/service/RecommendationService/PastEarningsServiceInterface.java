package com.cbfacademy.apiassessment.service.RecommendationService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.PastEarnings;

@Service
public interface PastEarningsServiceInterface {

    public Iterable<PastEarnings> getAllPastEarnings();
    public PastEarnings save(PastEarnings pastEarning);
    public Iterable<PastEarnings> saveAll(List<PastEarnings> pastEarningsList);
    public void addToDatabase(String filepath);
    public Iterable<PastEarnings> getPastFiveYearsQuarterlyEarnings();

    //TODO: CHANGE THESE METHODS TO METHODS THAT HANDLE PASTEARNINGS E.g CALCULATE VOLATILITY, AVERAGE CHANGE, ANYTHING ELSE THAT WILL BE PASSED TO THE FRONT

}
