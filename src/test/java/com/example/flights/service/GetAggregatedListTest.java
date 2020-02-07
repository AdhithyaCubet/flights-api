package com.example.flights.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.flights.model.Data;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebFluxTest
@AutoConfigureWebTestClient(timeout = "10000")
public class GetAggregatedListTest {
	@Autowired
	WebTestClient webTestClient;

	@Autowired
	GetAggregatedList getAggregatedFlux;

	@Test
	public void testListApi() {
		webTestClient.get().uri("/webflux").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBody(Data[].class)
				.consumeWith(response -> {
					Assert.assertNotNull(response.getResponseBody());
				});
	}
}
