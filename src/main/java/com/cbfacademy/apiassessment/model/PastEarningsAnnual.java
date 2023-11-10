package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class PastEarningsAnnual {
    LocalDate annualFiscalDateEnding;
    Double anualReportedEPS;

    public PastEarningsAnnual(){}

    public PastEarningsAnnual(LocalDate annualFiscalDateEnding, Double anualReportedEPS) {
        this.annualFiscalDateEnding = annualFiscalDateEnding;
        this.anualReportedEPS = anualReportedEPS;
    }

    public LocalDate getAnnualFiscalDateEnding() {
        return annualFiscalDateEnding;
    }

    public void setAnnualFiscalDateEnding(LocalDate annualFiscalDateEnding) {
        this.annualFiscalDateEnding = annualFiscalDateEnding;
    }

    public Double getAnualReportedEPS() {
        return anualReportedEPS;
    }

    public void setAnualReportedEPS(Double anualReportedEPS) {
        this.anualReportedEPS = anualReportedEPS;
    }


    
}
