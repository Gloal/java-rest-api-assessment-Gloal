package com.cbfacademy.apiassessment.service;

import java.io.File;

public interface ExpectedEarningsServiceInterface {
    

    void getEarningsFromCsv(File file) throws Exception;

}
