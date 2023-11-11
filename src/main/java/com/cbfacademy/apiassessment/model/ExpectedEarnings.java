package com.cbfacademy.apiassessment.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExpectedEarnings {

    @Id
    @UniqueElements
    private String symbol;
    private String name;
    private LocalDate reportedDate;
    private LocalDate fiscalDateEnding;
    private Double estimate;
    private String currency;

    public ExpectedEarnings(){};

    
}
