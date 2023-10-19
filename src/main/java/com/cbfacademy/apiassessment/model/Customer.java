package com.cbfacademy.apiassessment.model;

import org.yaml.snakeyaml.events.Event.ID;

public class Customer {
    private ID id;
    private String firstName;
    private String lastName;
    private String email;
    private InvestmentPreferences investmentPreferences;


    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public InvestmentPreferences getInvestmentPreferences() {
        return investmentPreferences;
    }
    public void setInvestmentPreferences(InvestmentPreferences investmentPreferences) {
        this.investmentPreferences = investmentPreferences;
    }
 
}
