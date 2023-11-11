package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.service.RecommendationService.PastEarningsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

import com.cbfacademy.apiassessment.model.PastEarnings;

@EntityScan(
        basePackageClasses = {App.class, Jsr310JpaConverters.class}
)

@SpringBootApplication
@RestController
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}
/* 
	@Bean
	CommandLineRunner runner (PastEarningsService pastEarningsService){
		return args ->{

			//read jsonfile and write to db
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<PastEarnings>> typeReference = new TypeReference<List<PastEarnings>>(){};

			InputStream InputStream = TypeReference.class.getResourceAsStream("src/main/resources/datafiles/past_earnings.json");
			try{
				List<PastEarnings> pastEarnings = objectMapper.readValue(InputStream, typeReference);
				pastEarningsService.saveAll(pastEarnings);
				System.out.println("Past earnings saved!!");
			}catch (IOException e) {
				System.out.println("Unable to save Past earnings "+ e.getMessage());
			}
				
			};
 
   	}
*/
	
}
