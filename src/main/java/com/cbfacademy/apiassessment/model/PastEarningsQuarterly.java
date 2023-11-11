package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;

public class PastEarningsQuarterly {
    LocalDate fiscalDateEnding;
    LocalDate reportedDate;
    Double reportedEPS;
    Double estimatedEPS;
    Double surprise;
    Double surprisePercentage;

    public PastEarningsQuarterly(){}

    public PastEarningsQuarterly(LocalDate fiscalDateEnding, LocalDate reportedDate,
            Double reportedEPS, Double estimatedEPS, Double surprise,
            Double surprisePercentage) {
        this.fiscalDateEnding = fiscalDateEnding;
        this.reportedDate = reportedDate;
        this.reportedEPS = reportedEPS;
        this.estimatedEPS = estimatedEPS;
        this.surprise = surprise;
        this.surprisePercentage = surprisePercentage;
    }

    public LocalDate getFiscalDateEnding() {
        return fiscalDateEnding;
    }

    public void setFiscalDateEnding(LocalDate fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public Double getReportedEPS() {
        return reportedEPS;
    }

    public void setReportedEPS(Double reportedEPS) {
        this.reportedEPS = reportedEPS;
    }

    public Double getEstimatedEPS() {
        return estimatedEPS;
    }

    public void setEstimatedEPS(Double estimatedEPS) {
        this.estimatedEPS = estimatedEPS;
    }

    public Double getSurprise() {
        return surprise;
    }

    public void setSurprise(Double surprise) {
        this.surprise = surprise;
    }

    public Double getSurprisePercentage() {
        return surprisePercentage;
    }

    public void setSurprisePercentage(Double surprisePercentage) {
        this.surprisePercentage = surprisePercentage;
    }  
}
