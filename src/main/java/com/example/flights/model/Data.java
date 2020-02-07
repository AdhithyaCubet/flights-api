package com.example.flights.model;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;

public class Data {
	private String source;
	private String destination;
	private long departureTime;
	private long arrivalTime;

	public Data(String source, String destination, long departureTime, long arrivalTime) {
		super();
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public static Comparator<Data> DataComparator = new Comparator<Data>() {

		public int compare(Data s1, Data s2) {
			Timestamp stamp1 = new Timestamp(s1.getDepartureTime());
			Date date1 = new Date(stamp1.getTime());
			Timestamp stamp2 = new Timestamp(s2.getDepartureTime());
			Date date2 = new Date(stamp2.getTime());
			return date1.compareTo(date2);
		}
	};

	@Override
	public String toString() {
		return "Data [source=" + source + ", destination=" + destination + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + "]";
	}

}
