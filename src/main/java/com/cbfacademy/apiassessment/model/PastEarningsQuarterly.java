package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class PastEarningsQuarterly {
    LocalDate quarterlyFiscalDateEnding;
    LocalDate quarterlyReportedDate;
    Double quarterlyReportedEPS;
    Double quarterlyEstimaatedEPS;
    Double quarterlySuprise;
    Double quarterlySuprisePercentage;

    public PastEarningsQuarterly(){}

    public PastEarningsQuarterly(LocalDate quarterlyFiscalDateEnding, LocalDate quarterlyReportedDate,
            Double quarterlyReportedEPS, Double quarterlyEstimaatedEPS, Double quarterlySuprise,
            Double quarterlySuprisePercentage) {
        this.quarterlyFiscalDateEnding = quarterlyFiscalDateEnding;
        this.quarterlyReportedDate = quarterlyReportedDate;
        this.quarterlyReportedEPS = quarterlyReportedEPS;
        this.quarterlyEstimaatedEPS = quarterlyEstimaatedEPS;
        this.quarterlySuprise = quarterlySuprise;
        this.quarterlySuprisePercentage = quarterlySuprisePercentage;
    }

    public LocalDate getQuarterlyFiscalDateEnding() {
        return quarterlyFiscalDateEnding;
    }

    public void setQuarterlyFiscalDateEnding(LocalDate quarterlyFiscalDateEnding) {
        this.quarterlyFiscalDateEnding = quarterlyFiscalDateEnding;
    }

    public LocalDate getQuarterlyReportedDate() {
        return quarterlyReportedDate;
    }

    public void setQuarterlyReportedDate(LocalDate quarterlyReportedDate) {
        this.quarterlyReportedDate = quarterlyReportedDate;
    }

    public Double getQuarterlyReportedEPS() {
        return quarterlyReportedEPS;
    }

    public void setQuarterlyReportedEPS(Double quarterlyReportedEPS) {
        this.quarterlyReportedEPS = quarterlyReportedEPS;
    }

    public Double getQuarterlyEstimaatedEPS() {
        return quarterlyEstimaatedEPS;
    }

    public void setQuarterlyEstimaatedEPS(Double quarterlyEstimaatedEPS) {
        this.quarterlyEstimaatedEPS = quarterlyEstimaatedEPS;
    }

    public Double getQuarterlySuprise() {
        return quarterlySuprise;
    }

    public void setQuarterlySuprise(Double quarterlySuprise) {
        this.quarterlySuprise = quarterlySuprise;
    }

    public Double getQuarterlySuprisePercentage() {
        return quarterlySuprisePercentage;
    }

    public void setQuarterlySuprisePercentage(Double quarterlySuprisePercentage) {
        this.quarterlySuprisePercentage = quarterlySuprisePercentage;
    }



}
