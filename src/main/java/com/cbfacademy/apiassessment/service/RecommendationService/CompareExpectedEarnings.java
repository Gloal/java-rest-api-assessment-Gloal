package com.cbfacademy.apiassessment.service.RecommendationService;

import java.io.File;

import ch.qos.logback.core.util.Duration;

public interface CompareExpectedEarnings {

    /*take in the company symbol, search the csv file for the predicted earnings
    Separated into 6months or 1 year intervals (query API and search CSV result)
    For 5+ yrs of investing, only return 1 year predictions */

    String getApiQueryString(String s, Duration duration);

    Double getExpectedEarnings(String companySymbol, File filename);
//??? SHould this take in any string and then decide how to serch based on file type later? 
//??? Or should I implement multiple getExpectedEarnings(csv, symbol) getExpectedEarnings(json, symbol)based on file input - csv or json

///Create one implementation for json and another for csv
//CompareExpectedEarningsCSV
//CompareExpectedEarningsJSON

}
