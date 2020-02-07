package com.example.flights.model;

import java.util.Optional;

public class CheapData {
	private String route;
	private long departure;
	private long arrival;

	public Optional<String> getRoute() {
		return Optional.ofNullable(route);
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Optional<Long> getDeparture() {
		return Optional.ofNullable(departure);
	}

	public void setDeparture(long departure) {
		this.departure = departure;
	}

	public Optional<Long> getArrival() {
		return Optional.ofNullable(arrival);
	}

	public void setArrival(long arrival) {
		this.arrival = arrival;
	}

}
