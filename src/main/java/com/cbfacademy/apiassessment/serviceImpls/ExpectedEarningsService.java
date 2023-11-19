package com.cbfacademy.apiassessment.serviceImpls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exception.SymbolNotFoundException;
import com.cbfacademy.apiassessment.model.ExpectedEarnings;
import com.cbfacademy.apiassessment.model.ExpectedEarningsRepoModel;
import com.cbfacademy.apiassessment.service.ExpectedEarningsServiceInterface;

import jakarta.annotation.PostConstruct;

@Configuration
@Service
public class ExpectedEarningsService implements ExpectedEarningsServiceInterface {

    private List<ExpectedEarnings> expectedEarningsList = new ArrayList<>();
    private File csvFile3Month = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");
    private File csvFile12Month = new File("src/main/resources/datafiles/expected_earnings_12_months.csv");


    public ExpectedEarningsService(){}

    private static final Logger logger = LogManager.getLogger(ExpectedEarningsService.class);

    public void getEarningsFromCsv(File csvFile) throws IOException {

        logger.info("Reading expected earnings from CSV: " + csvFile.getName());

        FileReader fileReader = new FileReader(csvFile);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String newline;
            reader.readLine();
            while ((newline = reader.readLine()) != null) {
                ExpectedEarnings expectedEarnings = ExpectedEarnings.parse(newline);
                expectedEarningsList.add(expectedEarnings);
            }
            expectedEarningsList.sort((object1, object2) -> object1.getSymbol()
                    .compareTo(object2.getSymbol()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ExpectedEarnings getExpectedEarningsForSymbol(String symbol, File csvFile) throws SymbolNotFoundException, IOException {
        logger.info("Getting expected earnings for Symbol : " + symbol);
        getEarningsFromCsv(csvFile);

        int position = binarySearchForExpectedEarningsBySymbol(symbol);
        if (position != -1) {
            return expectedEarningsList.get(position);
        } else {
            throw new SymbolNotFoundException();
        }
    }

    @Override
    public int binarySearchForExpectedEarningsBySymbol(String symbol) {
        int left = 0;
        int right = expectedEarningsList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int valueToCompare = expectedEarningsList.get(mid).getSymbol().compareToIgnoreCase(symbol);

            if (valueToCompare == 0) {
                return mid;
            } else if (valueToCompare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    /* 
    // to keep data in the database in case it is needed (but it is static so not
    // sure it is needed)

    public void getEarningsFromCsvAndStoreInDatabase(File file) throws Exception {
        logger.info("Getting expected earnings from csv file and assing to database");

        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            reader.lines()
                    .skip(1)
                    .map(ExpectedEarningsRepoModel::parse)
                    .forEach(expectedEarningsRepository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct // performed after initialised
    private void init() {

        File csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");
        logger.info("Reading expected earnings from CSV: " + csvFile.getName());

        try {
            getEarningsFromCsvAndStoreInDatabase(csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ExpectedEarnings findBySymbol(String symbol) {
        logger.info("Reading expected earnings from database for : " + symbol);

        return expectedEarningsRepository.findById(symbol).orElseThrow();
    }

    // TODO:: DELETE THIS IF IT WORKS OUTSIDE!
    public static void main(String[] args) throws Exception {
        File csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");

        ExpectedEarningsService expectedEarningsService = new ExpectedEarningsService();
        expectedEarningsService.getEarningsFromCsv(csvFile);
        String symbol = "IBM";

        ExpectedEarnings expectedEarnings = expectedEarningsService.getExpectedEarningsForSymbol(symbol);
        BigDecimal eatimatedEarnings = expectedEarnings.getEstimate();
        System.out.println(eatimatedEarnings);
    }

    */
}
