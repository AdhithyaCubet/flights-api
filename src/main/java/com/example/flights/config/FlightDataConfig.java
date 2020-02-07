package com.example.flights.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FlightDataConfig {
	@Value("${CHEAP_URL}")
	private String cheap;

	@Value("${BUSINESS_URL}")
	private String business;

	@Bean("cheapClient")
	public WebClient cheapClient() {
		return WebClient.create(cheap);
	}

	@Bean("businessClient")
	public WebClient businessClient() {
		return WebClient.create(business);
	}

}
