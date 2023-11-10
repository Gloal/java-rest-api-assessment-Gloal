package com.cbfacademy.apiassessment.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class CustomerInfo {
    //TODO: CHANGE ID FROM LONG TO AUTOGENERATED UUID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email
    //TODO: more specific email validation using regular expressions
    private String email;
    // @UniqueElements - to make sure all elemts in the investment preferences list is unique
    // InvestmentPreferences investmentPreferences;
    // Goal goal;
    // RiskLevel riskLevel;
    // Duration duration;
    // StockSymbol stockSymbol;
    // @DateTimeFormat
    // @PastOrPresent
    // LocalDateTime createdDate;
    // @DateTimeFormat
    // LocalDateTime updatedDate;
    CustomerInfo(){}

    public CustomerInfo( @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString(){
        return String.format(
            //TODO: FIND OUT WHY %s doesnt work but %S does
            //%s returns an error: [Request processing failed: java.util.MissingFormatArgumentException: Format specifier '%s'] with root cause
            //%S works fine
            "   {Customer id=%d, firstName=%S, lastName=%S }", id, firstName, lastName);
    } 
 
    public Long id() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

 
    
}
