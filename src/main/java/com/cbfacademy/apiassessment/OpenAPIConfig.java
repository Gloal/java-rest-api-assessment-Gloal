package com.cbfacademy.apiassessment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {


    Contact contact = new Contact();
    contact.setEmail("iAmTired@gmail.com");


    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("Investment Suitability Analysis API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to calculate the suitability of an Investment stock to a customer's investment goals and risk appetite.").termsOfService("FreeToUSe")
        .license(mitLicense);

    return new OpenAPI().info(info);
  }
}

