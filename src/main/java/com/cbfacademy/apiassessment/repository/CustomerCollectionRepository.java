package com.cbfacademy.apiassessment.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cbfacademy.apiassessment.model.CustomerInfo;


public interface CustomerCollectionRepository extends JpaRepository<CustomerInfo, Long>{
/* 
    public List<CustomerInfo> customerInfoList ;

    public CustomerCollectionRepository(List<CustomerInfo> customerInfoList){
        CustomerCollectionRepository.customerInfoList = customerInfoList;
    }
 */
    

    
}
