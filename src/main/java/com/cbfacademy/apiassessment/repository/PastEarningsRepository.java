package com.cbfacademy.apiassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbfacademy.apiassessment.model.PastEarnings;

public interface PastEarningsRepository extends JpaRepository <PastEarnings, Long> {

}
