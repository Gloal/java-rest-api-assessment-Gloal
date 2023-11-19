package com.cbfacademy.apiassessment.serviceImpls;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.exception.IdNotFoundException;
import com.cbfacademy.apiassessment.exception.SymbolNotFoundException;
import com.cbfacademy.apiassessment.model.CustomerInfo;
import com.cbfacademy.apiassessment.model.InvestmentPreferences;
import com.cbfacademy.apiassessment.repository.CustomerInfoRepository;
import com.cbfacademy.apiassessment.repository.InvestmentPreferencesRepository;
import com.cbfacademy.apiassessment.service.CustomerInfoServiceInterface;
import com.cbfacademy.apiassessment.service.RecommendationService.InvestmentSuitabilityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Configuration
@Service
public class CustomerInfoService implements CustomerInfoServiceInterface {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    
    @Autowired
    private InvestmentPreferencesRepository InvestmentPreferencesRepository;

    @Autowired
    private InvestmentSuitabilityService investmentSuitabilityService;



    @Override
    public void deleteCustomer(Long id) {
        if (customerInfoRepository.findById(id).isEmpty()) {
            throw new IdNotFoundException();
        }
        customerInfoRepository.deleteById(id);
    }

    @Override
    public List<CustomerInfo> getAllCustomerInfos() {
        return customerInfoRepository.findAll();
    }

    @Override
    public CustomerInfo getCustomerById(Long id) {
        if (customerInfoRepository.findById(id).isEmpty() || id == null) {
            throw new IdNotFoundException();
        }
        return customerInfoRepository.findById(id).get();
    }

    @Override
    public CustomerInfo createCustomer(CustomerInfo customerInfo) {
        return customerInfoRepository.save(customerInfo);
    }

    @Override
    public void updateCustomerInfo(Long id, CustomerInfo customerInfo) {

        CustomerInfo customerToUpdate = getCustomerById(id);
        customerToUpdate.setFirstName(customerInfo.getFirstName());
        customerToUpdate.setFirstName(customerInfo.getFirstName());
        customerToUpdate.setEmail(customerInfo.getEmail());
        customerInfoRepository.save(customerToUpdate);
    }

    public InvestmentPreferences addInvestmentPreferencesByCustomerId(Long id,
            InvestmentPreferences investmentPreferences) throws JsonMappingException, JsonProcessingException, SymbolNotFoundException, IOException {
        if (customerInfoRepository.findById(id).isEmpty()) {
            throw new IdNotFoundException();
        }
        CustomerInfo customer = getCustomerById(id);
        investmentPreferences.setCustomer(customer);
        setSymbolSuitability(investmentPreferences);
        customer.addInvestmentPreferences(investmentPreferences);
        customerInfoRepository.save(customer);
        return investmentPreferences;
    }

    public List<InvestmentPreferences> getAllInvestmentPreferencesByCustomerId(Long id) {
        if (customerInfoRepository.findById(id).isEmpty()) {
            throw new IdNotFoundException();
        }
        CustomerInfo customer = getCustomerById(id);
        List<InvestmentPreferences> investmentPreferences = customer.getInvestmentPreferences();
        return investmentPreferences;

    }

    public InvestmentPreferences getInvestmentPreferenceById(Long idCLong, Long idIPLong) {
        CustomerInfo customer = getCustomerById(idCLong);
        Optional<InvestmentPreferences> investmentPreferenceOptional = customer.getInvestmentPreferences()
                .stream().filter(ip -> ip.getId().equals(idIPLong)).findFirst();
        if (investmentPreferenceOptional.isEmpty()) {
            throw new IdNotFoundException();
        }

        return investmentPreferenceOptional.get();
    }

    public Object updateInvestmentPreference(Long idCLong, Long idIPLong, InvestmentPreferences investmentPreferences) throws JsonMappingException, JsonProcessingException, SymbolNotFoundException, IOException {
        InvestmentPreferences investmentPreferencesToUpdate = getInvestmentPreferenceById(idCLong, idIPLong);
        investmentPreferencesToUpdate.setInvestmentAmount(investmentPreferences.getInvestmentAmount());
        investmentPreferencesToUpdate.setDuration(investmentPreferences.getDuration());
        investmentPreferencesToUpdate.setRiskTolerance(investmentPreferences.getRiskTolerance());
        investmentPreferencesToUpdate.setInvestmentGoal(investmentPreferences.getInvestmentGoal());
        investmentPreferencesToUpdate.setChosenSymbol(investmentPreferences.getChosenSymbol());
        investmentPreferencesToUpdate.setCustomer(getCustomerById(idCLong));
        setSymbolSuitability(investmentPreferencesToUpdate);

        return InvestmentPreferencesRepository.save(investmentPreferencesToUpdate);
    }

    public void deleteInvestmentPreferences(Long idCLong, Long idIPLong) {
        InvestmentPreferences investmentPreferencesToDelete = getInvestmentPreferenceById(idCLong, idIPLong);
        System.out.println("To remove" +investmentPreferencesToDelete);
        CustomerInfo customer = customerInfoRepository.findById(idCLong).orElseThrow();
        System.out.println("Before remove: "+customer.getInvestmentPreferences());
        customer.removeInvestmentPreferences(investmentPreferencesToDelete);
                System.out.println("After remove: "+ customer.getInvestmentPreferences());
        updateCustomerInfo(idIPLong, customer);

    }
    

    public void setSymbolSuitability(InvestmentPreferences investmentPreferences) throws JsonMappingException, JsonProcessingException, SymbolNotFoundException, IOException{
         investmentSuitabilityService.setSymbolsuitability(investmentPreferences);
    }

}
