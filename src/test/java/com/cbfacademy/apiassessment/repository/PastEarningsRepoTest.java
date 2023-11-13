package com.cbfacademy.apiassessment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.model.Symbol;
import com.fasterxml.jackson.databind.JsonMappingException;

public class PastEarningsRepoTest {


    @Test
    void testGetPastEarnings() throws JsonMappingException, IOException {
        PastEarningsRepo pastEarningsRepo = new PastEarningsRepo();
        PastEarnings pastEarnings = pastEarningsRepo.getPastEarnings();

        assertEquals(pastEarnings.getSymbol(), Symbol.IBM);
    }
}
