package com.cbfacademy.apiassessment.model;

import java.util.List;

public class PastEarnings {

    private String symbol;
    private List<PastEarningsAnnual> annualEarnings;
    private List<PastEarningsQuarterly> quarterlyEarnings;

    public PastEarnings(){}

    public PastEarnings(String symbol, List<PastEarningsAnnual> annualEarnings,
            List<PastEarningsQuarterly> quarterlyEarnings) {
        this.symbol = symbol;
        this.annualEarnings = annualEarnings;
        this.quarterlyEarnings = quarterlyEarnings;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<PastEarningsAnnual> getAnnualEarnings() {
        return annualEarnings;
    }

    public void setAnnualEarnings(List<PastEarningsAnnual> annualEarnings) {
        this.annualEarnings = annualEarnings;
    }

    public List<PastEarningsQuarterly> getQuarterlyEarnings() {
        return quarterlyEarnings;
    }

    public void setQuarterlyEarnings(List<PastEarningsQuarterly> quarterlyEarnings) {
        this.quarterlyEarnings = quarterlyEarnings;
    }
}
