package com.cbfacademy.apiassessment.service;

import java.io.File;
import java.io.IOException;

import com.cbfacademy.apiassessment.exception.SymbolNotFoundException;
import com.cbfacademy.apiassessment.model.ExpectedEarnings;

public interface ExpectedEarningsServiceInterface {
    

    void getEarningsFromCsv(File file) throws IOException;

    ExpectedEarnings getExpectedEarningsForSymbol(String symbol, File file) throws SymbolNotFoundException, IOException;

    int binarySearchForExpectedEarningsBySymbol(String symbol);
}
