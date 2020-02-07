package com.example.flights.model;

import java.util.Optional;

public class BusinessData {

	private String arrival;
	private String departure;
	private Long departureTime;
	private Long arrivalTime;

	public Optional<String> getArrival() {
		return Optional.ofNullable(arrival);
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Optional<String> getDeparture() {
		return Optional.ofNullable(departure);
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public Optional<Long> getDepartureTime() {
		return Optional.ofNullable(departureTime);
	}

	public void setDepartureTime(Long departureTime) {
		this.departureTime = departureTime;
	}

	public Optional<Long> getArrivalTime() {
		return Optional.ofNullable(arrivalTime);
	}

	public void setArrivalTime(Long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
