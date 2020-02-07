package com.example.flights.model;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cheap {
	@JsonProperty("data")
	private List<CheapData> data;

	public Optional<List<CheapData>> getData() {
		return Optional.ofNullable(data);
	}

	public void setData(List<CheapData> data) {
		this.data = data;
	}

}