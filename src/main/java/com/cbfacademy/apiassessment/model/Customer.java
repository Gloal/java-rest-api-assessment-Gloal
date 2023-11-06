package com.cbfacademy.apiassessment.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//customer entity that will be saved, read, edited and deleted(by Id)
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;
    private String firstName; //editable
    private String lastName; //editable
    private String email; //editable - but must be unique
 //   private InvestmentPreferences investmentPreferences; //editable
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date updatedDate;


    public Customer(String firstName, String lastName, String email, InvestmentPreferences investmentPreferences){
       // this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.investmentPreferences = investmentPreferences;
    }

    public UUID getId() {
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
    // public InvestmentPreferences getInvestmentPreferences() {
    //     return investmentPreferences;
    // }
    // public void setInvestmentPreferences(InvestmentPreferences investmentPreferences) {
    //     this.investmentPreferences = investmentPreferences;
    // }

    public Date getCreatedDate(){
        return createdDate;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate(){
        return updatedDate;
    }

    public void setUpdatedate(Date updatedDate){
        this.updatedDate = updatedDate;
    }
}
