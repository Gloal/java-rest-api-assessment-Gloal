package com.cbfacademy.apiassessment.serviceImpls;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.model.PastEarningsAnnual;
import com.cbfacademy.apiassessment.repository.PastEarningsRepo;
import com.cbfacademy.apiassessment.service.PastEarningsServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PastEarningsService implements PastEarningsServiceInterface{


 PastEarningsRepo pastEarningsRepo;

    public PastEarningsService(){
    //TODO: get past data from 5 yrs ago 
        throw new UnsupportedOperationException("Unimplemented method 'getPastFiveYearsEarnings'");
    }

    @Override
    public PastEarnings savePastEarnings(PastEarnings pastEarning){
        throw new UnsupportedOperationException("Unimplemented method 'savePastEarnings'");
    }



    @Override
    public Iterable<PastEarnings> getPastFiveYearsQuarterlyEarnings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPastFiveYearsQuarterlyEarnings'");
    }
}
