package com.cbfacademy.apiassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbfacademy.apiassessment.model.ExpectedEarnings;

public interface ExpectedEarningsRepository extends JpaRepository<ExpectedEarnings, String>{
    
}
