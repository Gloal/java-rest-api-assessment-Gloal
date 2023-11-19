package com.cbfacademy.apiassessment.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="You must enter your first name")
    private String firstName;

    @NotEmpty(message="You must enter your lastt name")
    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String email;

    @OneToMany(mappedBy = "customerInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    List<InvestmentPreferences> investmentPreferencesList = new ArrayList<>();
    
    @CreationTimestamp
    @PastOrPresent
    LocalDateTime createdDate;

    
    @UpdateTimestamp
    LocalDateTime updatedDate;


    CustomerInfo(){}
    
    public CustomerInfo(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty @Email String email) {
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
            "{Customer id=%d, firstName=%S, lastName=%S }" , id, firstName, lastName);
    } 
 
    public Long getId() {
        return id;
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

    public void addInvestmentPreferences(InvestmentPreferences investmentPreferences) {
        investmentPreferences.setCustomer(this);
        investmentPreferencesList.add(investmentPreferences);
    }

    public void removeInvestmentPreferences(InvestmentPreferences investmentPreferences) {
        investmentPreferencesList.remove(investmentPreferences);
        investmentPreferences.setCustomer(null);
    }

    public List<InvestmentPreferences> getInvestmentPreferences() {
        return investmentPreferencesList;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }


    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

}
