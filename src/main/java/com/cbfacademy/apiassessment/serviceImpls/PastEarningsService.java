package com.cbfacademy.apiassessment.serviceImpls;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.model.PastEarningsQuarterly;
import com.cbfacademy.apiassessment.service.PastEarningsServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
@Service
public class PastEarningsService implements PastEarningsServiceInterface{

    private static final Logger logger = LogManager.getLogger(PastEarningsService.class);


    PastEarnings pastEarnings;

    public PastEarningsService(){
    }


    public PastEarnings loadPastEarningsBySymbol(String symbol) throws IOException, JsonProcessingException, JsonMappingException {

        logger.info("Reading past earnings from JSON file for symbol: "+ symbol);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Path jsonFile = Paths.get("src/main/resources/datafiles/"+symbol+"_earnings.json");

        String json = new String(Files.readAllBytes(jsonFile));

        JsonNode jsonNode = objectMapper.readTree(json);
        handleNode(jsonNode);

        var pastEarnings = objectMapper.treeToValue(jsonNode,
                PastEarnings.class);

        return pastEarnings;
    }

    public double calculateRiskForSymbol(PastEarnings pastEarnings){
        return 0.0;
    }

//TODO: DELETE THIS BEFORE COMMITING
    public static void main(String[] args) throws IOException, JsonProcessingException, JsonMappingException{
        String symbol = "IBM";
        PastEarnings pastEarnings = new PastEarnings();
        PastEarningsService pastEarningsService = new PastEarningsService();

        pastEarnings = pastEarningsService.loadPastEarningsBySymbol(symbol);
        double stdDeviation = pastEarningsService.calculateStandardDeviation(pastEarnings);
        String risk = pastEarningsService.categoriseRisk(stdDeviation);
        System.out.println(risk);
    }

    public double calculateStandardDeviation(PastEarnings pastEarnings){
        DescriptiveStatistics calc = new DescriptiveStatistics(); 
        logger.info("Calculating past earnings' standard deviation for symbol: "+ pastEarnings.getSymbol());

        List<Double> pastFiveYearsList = pastEarnings.getQuarterlyEarnings().stream()
                                                    .limit(20).map(PastEarningsQuarterly::getSurprisePercentage)
                                                    .collect(Collectors.toList());

        for (double pastqrtly: pastFiveYearsList){
            calc.addValue(pastqrtly);
        }
        double calculatedStdDeviation = calc.getStandardDeviation();
    
        return calculatedStdDeviation;
    }
     
    
    public String categoriseRisk(double stdDeviation){
        if(stdDeviation < 10){
            return "Low";
        }else if (stdDeviation >= 10 && stdDeviation < 30){
            return "Moderate";
        }else {
            return "High";
        }
    }

    private void handleNode(JsonNode node) {
    if (node.isObject()) {
        ObjectNode objectNode = (ObjectNode) node;
        Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            JsonNode valueNode = field.getValue();

            if (valueNode.isTextual() && "None".equals(valueNode.textValue())) {
                objectNode.putNull(field.getKey());
            } else {
                handleNode(valueNode);
            }
        }
    } else if (node.isArray()) {
        ArrayNode arrayNode = (ArrayNode) node;
        for (JsonNode jsonNode : arrayNode) {
            handleNode(jsonNode);
        }
    }
}
    
    @Override
    public PastEarnings getAllPastEarningsBySymbol(String symbol) {
        try{
            return loadPastEarningsBySymbol(symbol);
        }catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
