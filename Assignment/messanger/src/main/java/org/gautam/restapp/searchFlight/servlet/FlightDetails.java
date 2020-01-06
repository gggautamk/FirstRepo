package org.gautam.restapp.searchFlight.servlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightDetails implements Comparable<FlightDetails> {

	public static final SimpleDateFormat dateFormat1 = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");
	public static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("M-dd-yyyy hh:mm:ss");
	public static final String ProviderName2 ="Provider2";

	String providerName;
	String origin;
	Date departureTime;
	String destination;
	Date destinationTime;
	double price;

	public FlightDetails(String providerName, String origin, String departureTimeStringFormat, String destination,
			String destinationTimeStringFormat, double price) throws ParseException {
		this.providerName = providerName;
		this.origin = origin;
		if(providerName.equals(ProviderName2))
		this.departureTime = dateFormat2.parse(departureTimeStringFormat);
		else
		this.departureTime = dateFormat1.parse(departureTimeStringFormat);
		this.destination = destination;
		if(providerName.equals(ProviderName2))
		this.destinationTime = dateFormat2.parse(destinationTimeStringFormat);
		else
		this.destinationTime = dateFormat1.parse(destinationTimeStringFormat);	
		this.price = price;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(Date destinationTime) {
		this.destinationTime = destinationTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FlightDetails [providerName=" + providerName + ", origin=" + origin + ", departureTime=" + departureTime
				+ ", destination=" + destination + ", destinationTime=" + destinationTime + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((providerName == null) ? 0 : providerName.hashCode());
		return result;
	}

	//Will be utilized when storing the elements with Set Implementing Classes 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDetails other = (FlightDetails) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (providerName == null) {
			if (other.providerName != null)
				return false;
		} else if (!providerName.equals(other.providerName))
			return false;

		if (providerName.equals(other.providerName) && origin.equals(other.origin)
				&& destination.equals(other.destination))
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(FlightDetails flightDetail) {

		if (price == flightDetail.getPrice()) {
			int compareData = departureTime.compareTo(flightDetail.getDepartureTime());
			if (compareData != 0)
				return compareData;
			else if (providerName.equals(flightDetail.getProviderName()) && origin.equals(flightDetail.getOrigin())
					&& destination.equals(flightDetail.getDestination()))
				return 0;
			else
				return 1;
		} else if (price > flightDetail.getPrice()) {
			return 1;
		} else {
			return -1;
		}
	}

}
