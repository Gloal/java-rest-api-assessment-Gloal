package com.cbfacademy.apiassessment.service.RecommendationService;

import com.cbfacademy.apiassessment.model.ExpectedEarnings;
import com.cbfacademy.apiassessment.model.InvestmentPreferences;
import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.model.RiskLevel;
import com.cbfacademy.apiassessment.serviceImpls.ExpectedEarningsService;
import com.cbfacademy.apiassessment.serviceImpls.PastEarningsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InvestmentSuitabilityServiceTest {

    @Autowired
    private InvestmentSuitabilityService investmentSuitabilityService;

    @MockBean
    private ExpectedEarningsService expectedEarningsService;

    @MockBean
    private PastEarningsService pastEarningsService;

    private File csvFile;

    //creat instances for Invesrment Preferences
    private InvestmentPreferences investmentPreferences;
    private ExpectedEarnings expectedEarnings;
    private PastEarnings pastEarnings;

    @BeforeEach
    public void setUp() {
        csvFile = new File("src/main/resources/datafiles/expected_earnings_3_months.csv");
        investmentPreferences = new InvestmentPreferences();
        investmentPreferences.setChosenSymbol("AAPL");
        investmentPreferences.setRiskTolerance(RiskLevel.LOW);

        expectedEarnings = new ExpectedEarnings(null, null, null, null, null, null);
        expectedEarnings.setSymbol("AAPL");
        expectedEarnings.setEstimate(1.0);

        pastEarnings = new PastEarnings();
        pastEarnings.setSymbol("AAPL");
        pastEarnings.setActual(1.0);
        pastEarnings.setEstimate(1.0);
    }

    @Test
    @DisplayName("Test setSymbolsuitability with valid input and low risk tolerance")
    public void testSetSymbolsuitabilityWithValidInputAndLowRiskTolerance() throws Exception {
        Mockito.when(expectedEarningsService.getEarningsFromCsv(csvFile)).thenReturn(expectedEarnings);
        Mockito.when(investmentSuitabilityService.returnExpectedEarningsForSymbol("AAPL", csvFile)).thenReturn(expectedEarnings);
        Mockito.when(pastEarningsService.loadPastEarningsBySymbol("AAPL")).thenReturn(pastEarnings);
        Mockito.when(pastEarningsService.calculateStandardDeviation(pastEarnings)).thenReturn(0.0);
        Mockito.when(pastEarningsService.categoriseRisk(0.0)).thenReturn("Low");

        investmentSuitabilityService.setSymbolsuitability(investmentPreferences);

        assertEquals("Suitable", investmentPreferences.getSuitability());
        Mockito.verify(expectedEarningsService, Mockito.times(1)).getEarningsFromCsv(csvFile);
        Mockito.verify(investmentSuitabilityService, Mockito.times(1)).returnExpectedEarningsForSymbol("AAPL", csvFile);
        Mockito.verify(pastEarningsService, Mockito.times(1)).loadPastEarningsBySymbol("AAPL");
        Mockito.verify(pastEarningsService, Mockito.times(1)).calculateStandardDeviation(pastEarnings);
        Mockito.verify(pastEarningsService, Mockito.times(1)).categoriseRisk(0.0);
    }


        @Test
    void testReturnExpectedEarningsForSymbol() {

    }

    @Test
    void testSetSymbolsuitability() {

}
