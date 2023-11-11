package com.cbfacademy.apiassessment.model;

import java.util.List;

public class PastEarnings {

    private Symbol symbol;
    private List<PastEarningsAnnual> annualEarnings;
    private List<PastEarningsQuarterly> quarterlyEarnings;

    public PastEarnings(){}

    public PastEarnings(Symbol symbol, List<PastEarningsAnnual> annualEarnings,
            List<PastEarningsQuarterly> quarterlyEarnings) {
        this.symbol = symbol;
        this.annualEarnings = annualEarnings;
        this.quarterlyEarnings = quarterlyEarnings;
    }


    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
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
