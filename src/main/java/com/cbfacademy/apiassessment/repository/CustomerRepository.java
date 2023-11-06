package com.cbfacademy.apiassessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
