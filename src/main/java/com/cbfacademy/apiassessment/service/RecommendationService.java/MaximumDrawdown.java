package com.cbfacademy.apiassessment.stockresource;

public interface MaximumDrawdown {

    //TODO: Calculate Maximum Drawdown of each stock 
    //Maximum Drawdown% = (PeakValue - TroughValue)/PeakValue 
    //choose a time period based on the preferences
    //return volatility risk
    int getMaximumDrawdown(String s);
    
}
