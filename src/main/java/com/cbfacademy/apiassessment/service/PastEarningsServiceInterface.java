package com.cbfacademy.apiassessment.service;


import com.cbfacademy.apiassessment.model.PastEarnings;

public interface PastEarningsServiceInterface {

    public PastEarnings getAllPastEarningsBySymbol(String symbol);
    public PastEarnings savePastEarnings(PastEarnings pastEarning);
    public Iterable<PastEarnings> getPastFiveYearsQuarterlyEarnings();

}
