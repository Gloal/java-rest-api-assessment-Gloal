package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;

public class PastEarningsAnnual {
    LocalDate fiscalDateEnding;
    Double reportedEPS;

    public PastEarningsAnnual(){}

    public PastEarningsAnnual(LocalDate fiscalDateEnding, Double reportedEPS) {
        this.fiscalDateEnding = fiscalDateEnding;
        this.reportedEPS = reportedEPS;
    }

    public LocalDate getfiscalDateEnding() {
        return fiscalDateEnding;
    }

    public void setfiscalDateEnding(LocalDate fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    }

    public Double getreportedEPS() {
        return reportedEPS;
    }

    public void setreportedEPS(Double reportedEPS) {
        this.reportedEPS = reportedEPS;
    }


    
}
