package com.cbfacademy.apiassessment;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.repository.ExpectedEarningsRepository;
import com.cbfacademy.apiassessment.serviceImpls.ExpectedEarningsService;

@EntityScan(basePackageClasses = { App.class, Jsr310JpaConverters.class })

@SpringBootApplication
@RestController
public class App {
	@Autowired
	ExpectedEarningsService expectedEarningsService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

}
