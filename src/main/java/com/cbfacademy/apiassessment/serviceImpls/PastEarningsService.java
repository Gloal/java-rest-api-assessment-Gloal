package com.cbfacademy.apiassessment.serviceImpls;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.repository.PastEarningsRepo;
import com.cbfacademy.apiassessment.service.PastEarningsServiceInterface;


public class PastEarningsService implements PastEarningsServiceInterface{


 PastEarningsRepo pastEarningsRepo;

    public PastEarningsService(){
    //TODO: get past data from 5 yrs ago 
        throw new UnsupportedOperationException("Unimplemented method ''");
    }

    @Override
    public PastEarnings savePastEarnings(PastEarnings pastEarning){
        throw new UnsupportedOperationException("Unimplemented method 'savePastEarnings'");
    }


    @Override
    public Iterable<PastEarnings> getAllPastEarnings(){
        throw new UnsupportedOperationException("Unimplemented method 'getAllPastEarnings'");
    }

    @Override
    public Iterable<PastEarnings> getPastFiveYearsQuarterlyEarnings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPastFiveYearsQuarterlyEarnings'");
    }
}
