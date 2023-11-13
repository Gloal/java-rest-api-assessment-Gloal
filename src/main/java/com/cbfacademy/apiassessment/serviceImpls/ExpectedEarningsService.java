package com.cbfacademy.apiassessment.serviceImpls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.ExpectedEarnings;
import com.cbfacademy.apiassessment.repository.ExpectedEarningsRepository;
import com.cbfacademy.apiassessment.service.ExpectedEarningsServiceInterface;

import jakarta.annotation.PostConstruct;

@Configuration
@Service
public class ExpectedEarningsService implements ExpectedEarningsServiceInterface {

    @Autowired
    private ExpectedEarningsRepository expectedEarningsRepository;

    File csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");

    public ExpectedEarningsService() {

    }

    public ExpectedEarningsService(ExpectedEarningsRepository expectedEarningsRepository) {
        this.expectedEarningsRepository = expectedEarningsRepository;
    }

    @Override
    public void getEarningsFromCsv(File file) throws Exception {

        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            reader.lines()
                    .skip(1)
                    .map(ExpectedEarnings::parse)
                    .forEach(expectedEarningsRepository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct // performed after initialised
    private void init() {
        File csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");

        try {
            getEarningsFromCsv(csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
