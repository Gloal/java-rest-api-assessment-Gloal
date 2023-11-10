package com.cbfacademy.apiassessment.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PastEarnings {

    @Id
    long id;
    private StockSymbol stockSymbol;
    @Embedded
    private PastEarningsAnnual annualEarnings;
    @Embedded
    private PastEarningsQuarterly quarterlyEarnings;

    public PastEarnings(){}

    public PastEarnings(long id, StockSymbol stockSymbol, PastEarningsAnnual annualEarnings,
            PastEarningsQuarterly quarterlyEarnings) {
        this.id = id;
        this.stockSymbol = stockSymbol;
        this.annualEarnings = annualEarnings;
        this.quarterlyEarnings = quarterlyEarnings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(StockSymbol stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public PastEarningsAnnual getAnnualEarnings() {
        return annualEarnings;
    }

    public void setAnnualEarnings(PastEarningsAnnual annualEarnings) {
        this.annualEarnings = annualEarnings;
    }

    public PastEarningsQuarterly getQuarterlyEarnings() {
        return quarterlyEarnings;
    }

    public void setQuarterlyEarnings(PastEarningsQuarterly quarterlyEarnings) {
        this.quarterlyEarnings = quarterlyEarnings;
    }
    
    
}
