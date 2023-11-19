package com.cbfacademy.apiassessment.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.model.InvestmentPreferences;


public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long>{
    
    //@Query("SELECT c.investmentPreferences FROM CustomerInfo c WHERE c.id = :customerInfoId")
    //Optional<InvestmentPreferences> findInvestmentPreferencesByCustomerId(@Param("customerInfoId") Long customerInfoId);
}

