package com.cbfacademy.apiassessment.serviceImpls;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class PastEarningsServiceTest {
    private PastEarningsService pastEarningsService = new PastEarningsService();

    @Test
    void testGetAllPastEarningsBySymbol() {
        PastEarnings pastEarnings = pastEarningsService.getAllPastEarningsBySymbol("IBM");
        Assertions.assertNotNull(pastEarnings);
        assertEquals("IBM", pastEarnings.getSymbol());
    }

    @Test
    void testLoadPastEarningsBySymbol() throws JsonMappingException, JsonProcessingException, IOException {
        PastEarnings pastEarnings = pastEarningsService.loadPastEarningsBySymbol("IBM");
        Assertions.assertNotNull(pastEarnings);
        assertEquals("IBM", pastEarnings.getSymbol());

    }

    @Test
    void testLoadPastEarningsBySymbolThatDoesNotExist() {
        assertThrows(IOException.class, () -> {
            pastEarningsService.loadPastEarningsBySymbol("AA");
        });

    }

    @Test
    void testCategoriseRiskForLowRisk() {
        double stdDeviation1 = 5.0;
        assertEquals("Low", pastEarningsService.categoriseRisk(stdDeviation1));
        double stdDeviation2 = 15.0;
        assertEquals("Moderate", pastEarningsService.categoriseRisk(stdDeviation2));
        double stdDeviation3 = 35.0;
        assertEquals("High", pastEarningsService.categoriseRisk(stdDeviation3));
    }
}