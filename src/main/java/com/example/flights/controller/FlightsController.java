package com.example.flights.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flights.exception.DataException;
import com.example.flights.model.Data;
import com.example.flights.service.GetAggregatedList;

import reactor.core.publisher.Mono;

@RestController
public class FlightsController {

	@Autowired
	private GetAggregatedList getAggregatedList;

	@GetMapping(path = "/webflux", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<List<Data>> getDataList() {

		return getAggregatedList.getDataList().log().onErrorMap(exception -> new DataException("Error"));

	}
	}
