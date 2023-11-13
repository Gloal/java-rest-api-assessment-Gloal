package com.cbfacademy.apiassessment.service;


import com.cbfacademy.apiassessment.model.PastEarnings;

public interface PastEarningsServiceInterface {

    public Iterable<PastEarnings> getAllPastEarnings();
    public PastEarnings savePastEarnings(PastEarnings pastEarning);
    public Iterable<PastEarnings> getPastFiveYearsQuarterlyEarnings();

    //TODO: CHANGE THESE METHODS TO METHODS THAT HANDLE PASTEARNINGS E.g CALCULATE VOLATILITY, AVERAGE CHANGE, ANYTHING ELSE THAT WILL BE PASSED TO THE FRONT

}
