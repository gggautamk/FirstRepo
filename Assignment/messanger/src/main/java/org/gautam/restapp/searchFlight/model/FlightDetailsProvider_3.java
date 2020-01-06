package org.gautam.restapp.searchFlight.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightDetailsProvider_3 {
	
	private String origin;
	private String departureTime ;
	private String destination;
	private String destinationTime;
	private String price;
	
	FlightDetailsProvider_3(){
		
	}

	public FlightDetailsProvider_3(String origin, String departureTime, String destination, String destinationTime,
			String price) {
		this.origin = origin;
		this.departureTime = departureTime;
		this.destination = destination;
		this.destinationTime = destinationTime;
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FlightDetailsProvider_3 [origin=" + origin + ", departureTime=" + departureTime + ", destination="
				+ destination + ", destinationTime=" + destinationTime + ", price=" + price + "]";
	}
	
	
	

}
