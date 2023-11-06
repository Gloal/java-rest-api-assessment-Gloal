package com.cbfacademy.apiassessment.model;

public class InvestmentPreferences {

    private double investmentAmount;
    private int investmentDuration;
    private Risk riskTolerance;
    private Goal investmentGoal;

    public InvestmentPreferences(){
    }

    public Risk getRiskTolerance() {
        return riskTolerance;
    }
    public void setRiskTolerance(Risk riskTolerance) {
        this.riskTolerance = riskTolerance;
    }
    public double getInvestmentAmount() {
        return investmentAmount;
    }
    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
    public int getInvestmentDuration() {
        return investmentDuration;
    }
    public void setInvestmentDuration(int investmentDuration) {
        this.investmentDuration = investmentDuration;
    }
    public Goal getInvestmentGoal() {
        return investmentGoal;
    }
    public void setInvestmentGoal(Goal investmentGoal) {
        this.investmentGoal = investmentGoal;
    }
}
