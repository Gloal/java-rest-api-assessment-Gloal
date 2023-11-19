package com.cbfacademy.apiassessment.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.UniqueElements;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExpectedEarningsRepoModel {

    @Id
    @CsvBindByName
    private String symbol;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private LocalDate reportedDate;
    @CsvBindByName
    private LocalDate fiscalDateEnding;
    @CsvBindByName
    private BigDecimal estimate;
    @CsvBindByName
    private String currency;

    public ExpectedEarningsRepoModel() {
    }

    public ExpectedEarningsRepoModel(@UniqueElements String symbol, String name, LocalDate reportedDate,
            LocalDate fiscalDateEnding,
            BigDecimal estimate, String currency) {
        this.symbol = symbol;
        this.name = name;
        this.reportedDate = reportedDate;
        this.fiscalDateEnding = fiscalDateEnding;
        this.estimate = estimate;
        this.currency = currency;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public LocalDate getFiscalDateEnding() {
        return fiscalDateEnding;
    }

    public void setFiscalDateEnding(LocalDate fiscalDateEnding) {
        this.fiscalDateEnding = fiscalDateEnding;
    }

    public BigDecimal getEstimate() {
        return estimate;
    }

    public void setEstimate(BigDecimal estimate) {
        this.estimate = estimate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    };

    public static ExpectedEarnings parse(String csvLine){
        String datePattern="yyyy-MM-dd";
        String[] csvColumns = csvLine.split(",\\s*");

        LocalDate reptdDate =  LocalDate.parse(csvColumns[2], DateTimeFormatter.ofPattern(datePattern));
        LocalDate fisDateEnding =  LocalDate.parse(csvColumns[2], DateTimeFormatter.ofPattern(datePattern));
        BigDecimal estimate;
        if(csvColumns[4].isEmpty()){
            estimate = BigDecimal.ZERO;
        }else {
            estimate = new BigDecimal(csvColumns[4]);
        }

        return new ExpectedEarnings(csvColumns[0], csvColumns[1], reptdDate, fisDateEnding, estimate, csvColumns[5]);
    }
}
