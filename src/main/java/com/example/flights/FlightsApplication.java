package com.example.flights;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.flights")
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class FlightsApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(FlightsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
		LOGGER.info("Flights Applicaton Started");
			 
	}

}
