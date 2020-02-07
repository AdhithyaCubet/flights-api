package com.example.flights.model;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Business {
	@JsonProperty("data")
    private List<BusinessData> data;

	public Optional<List<BusinessData>> getData() {
		return Optional.ofNullable(data);
	}

	public void setData(List<BusinessData> data) {
		this.data = data;
	}

}
