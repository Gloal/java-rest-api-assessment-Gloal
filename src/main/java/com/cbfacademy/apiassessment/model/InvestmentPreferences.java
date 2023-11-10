package com.cbfacademy.apiassessment.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class InvestmentPreferences {
  
    private double investmentAmount;
    @Enumerated(EnumType.STRING)
    private Duration duration;
    @Enumerated(EnumType.STRING)
    private RiskLevel riskTolerance;
    @Enumerated(EnumType.STRING)
    private Goal investmentGoal;
    private StockSymbol chosenStockSymbol;

    public InvestmentPreferences(){}

    public InvestmentPreferences(double investmentAmount, com.cbfacademy.apiassessment.model.Duration duration,
            RiskLevel riskTolerance, Goal investmentGoal, StockSymbol chosenStockSymbol) {
        this.investmentAmount = investmentAmount;
        this.duration = duration;
        this.riskTolerance = riskTolerance;
        this.investmentGoal = investmentGoal;
        this.chosenStockSymbol = chosenStockSymbol;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public RiskLevel getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(RiskLevel riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    public Goal getInvestmentGoal() {
        return investmentGoal;
    }

    public void setInvestmentGoal(Goal investmentGoal) {
        this.investmentGoal = investmentGoal;
    }

    public StockSymbol getChosenStockSymbol() {
        return chosenStockSymbol;
    }

    public void setChosenStockSymbol(StockSymbol chosenStockSymbol) {
        this.chosenStockSymbol = chosenStockSymbol;
    }

    

}
