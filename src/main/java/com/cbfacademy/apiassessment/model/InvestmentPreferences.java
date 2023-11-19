package com.cbfacademy.apiassessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InvestmentPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double investmentAmount;
    @Enumerated(EnumType.STRING)
    private Duration duration;
    @Enumerated(EnumType.STRING)
    private RiskLevel riskTolerance;
    @Enumerated(EnumType.STRING)
    private Goal investmentGoal;
    private String chosenSymbol;
    private String suitability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerInfo_Id")
    CustomerInfo customerInfo;

    public InvestmentPreferences(){}

    public InvestmentPreferences(double investmentAmount, com.cbfacademy.apiassessment.model.Duration duration,
            RiskLevel riskTolerance, Goal investmentGoal, String chosenSymbol) {
        this.investmentAmount = investmentAmount;
        this.duration = duration;
        this.riskTolerance = riskTolerance;
        this.investmentGoal = investmentGoal;
        this.chosenSymbol = chosenSymbol;
    }

    public Long getId(){
        return id;
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

    public String getChosenSymbol() {
        return chosenSymbol;
    }

    public void setChosenSymbol(String chosenSymbol) {
        this.chosenSymbol = chosenSymbol;
    }

    public void setCustomer(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    @Override
    public String toString(){
        return 
            "Investment Amount: "+investmentAmount+ "  Duration: "+duration+
            "  Risk Tolerance: "+riskTolerance+"  Chosen Symbol: " +chosenSymbol;
    }

    public String getSuitability() {
        return suitability;
    }

    public void setSuitability(String suitability) {
        this.suitability = suitability;
    } 
    

}
