package com.cbfacademy.apiassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.InvestmentPreferences;

@Repository
public interface InvestmentPreferencesRepository extends JpaRepository<InvestmentPreferences, Long>{

}
