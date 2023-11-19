package com.cbfacademy.apiassessment.service.RecommendationService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.h2.api.JavaObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exception.SymbolNotFoundException;
import com.cbfacademy.apiassessment.model.Duration;
import com.cbfacademy.apiassessment.model.ExpectedEarnings;
import com.cbfacademy.apiassessment.model.Goal;
import com.cbfacademy.apiassessment.model.InvestmentPreferences;
import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.model.RiskLevel;
import com.cbfacademy.apiassessment.serviceImpls.ExpectedEarningsService;
import com.cbfacademy.apiassessment.serviceImpls.PastEarningsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ComponentScan
@Service
public class InvestmentSuitabilityService {

    @Autowired
    private ExpectedEarningsService expectedEarningsService;

    @Autowired
    private PastEarningsService pastEarningsService;

    public InvestmentSuitabilityService(ExpectedEarningsService expectedEarningsService) {
        this.expectedEarningsService = expectedEarningsService;
    }

    public void setSymbolsuitability(InvestmentPreferences investmentPreferences)
            throws SymbolNotFoundException, JsonMappingException, JsonProcessingException, IOException {

        File csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");
        String symbol = investmentPreferences.getChosenSymbol();

        expectedEarningsService.getEarningsFromCsv(csvFile);
        ExpectedEarnings expectedEarnings = returnExpectedEarningsForSymbol(symbol, csvFile);
        double expEarningsForSymbol = expectedEarnings.getEstimate().doubleValue();
        String expRating = getExpRating(expEarningsForSymbol);

        PastEarnings pastEarnings = new PastEarnings();
        pastEarnings = pastEarningsService.loadPastEarningsBySymbol(symbol);
        double pastVariance = pastEarningsService.calculateStandardDeviation(pastEarnings);
        String pastRiskRating = pastEarningsService.categoriseRisk(pastVariance);

        calculateSuitability(expRating, pastRiskRating, investmentPreferences);

    }

    private void calculateSuitability(String expRating, String pastRiskRating,
            InvestmentPreferences investmentPreferences) {
        if (investmentPreferences.getRiskTolerance() == RiskLevel.LOW) {
            if (expRating == "Low" && pastRiskRating == "Low") {
                investmentPreferences.setSuitability("Suitable");
            } else {
                investmentPreferences.setSuitability("Not Suitable");
            }
        } else if (investmentPreferences.getRiskTolerance() == RiskLevel.MODERATE) {
            if ((expRating == "Low") && (pastRiskRating == "Moderate" || pastRiskRating == "Low")) {
                investmentPreferences.setSuitability("Suitable");
            } else {
                investmentPreferences.setSuitability("Not Suitable");
            }
        } else if (investmentPreferences.getRiskTolerance() == RiskLevel.HIGH) {
            investmentPreferences.setSuitability("Suitable");
        }
    }


    private String getExpRating(double expEarningsForSymbol) {
        if (expEarningsForSymbol > 0) {
            return "Low";
        } else {
            return "High";
        }
    }

    public ExpectedEarnings returnExpectedEarningsForSymbol(String symbol, File csvFile)
            throws SymbolNotFoundException, IOException {
        return expectedEarningsService.getExpectedEarningsForSymbol(symbol, csvFile);
    }

    public static void main(String... args)
            throws SymbolNotFoundException, JsonMappingException, JsonProcessingException, IOException {
        ExpectedEarningsService expectedEarningsServices = new ExpectedEarningsService();

        InvestmentSuitabilityService investmentSuitabilityService = new InvestmentSuitabilityService(
                expectedEarningsServices);
        PastEarningsService pastEarningsService = new PastEarningsService();
        InvestmentPreferences investmentPreferences = new InvestmentPreferences(100, Duration.ONE_YEAR, RiskLevel.HIGH,
                Goal.RETIREMENT, "AAA");

        String symbol = "MGNI";

        File csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");

        expectedEarningsServices.getEarningsFromCsv(csvFile);
        ExpectedEarnings expectedEarnings = investmentSuitabilityService.returnExpectedEarningsForSymbol(symbol,
                csvFile);
        double expEarningsForSymbol = expectedEarnings.getEstimate().doubleValue();
        String expRating = investmentSuitabilityService.getExpRating(expEarningsForSymbol);

        System.out.println("ExpectedRating " + expRating);

        PastEarnings pastEarnings = new PastEarnings();
        pastEarnings = pastEarningsService.loadPastEarningsBySymbol(symbol);
        double pastVariance = pastEarningsService.calculateStandardDeviation(pastEarnings);
        String pastRiskRating = pastEarningsService.categoriseRisk(pastVariance);

        System.out.println("PastRating " + pastRiskRating);
        investmentSuitabilityService.calculateSuitability(expRating, pastRiskRating, investmentPreferences);

        System.out.println(investmentPreferences.getSuitability());
    }

}
