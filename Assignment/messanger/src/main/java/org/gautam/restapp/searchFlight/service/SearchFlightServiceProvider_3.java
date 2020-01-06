package org.gautam.restapp.searchFlight.service;

import java.util.ArrayList;
import java.util.List;

import org.gautam.restapp.searchFlight.model.FlightDetailsProvider_3;

public class SearchFlightServiceProvider_3 {
	
	//HarCoded data in realTime to be fetched from DB
	public static List<String> fetchFlightDetailsListProvider3(){
		
		List<String> flightDetails = new ArrayList<String>();
		flightDetails.add("LAS|6/29/2014 14:55:00|LAX|6/29/2014 16:10:00|$201.00");
		flightDetails.add("MIA|6/17/2014 14:55:00|ORD|6/17/2014 17:10:00|$542.00");
		flightDetails.add("LAS|6/29/2014 7:30:00|YYZ|6/29/2014 13:58:00|$678.00");
		flightDetails.add("YYZ|6/22/2014 12:00:00|YYC|6/22/2014 14:09:00|$630.00");
		flightDetails.add("JFK|6/15/2014 9:30:00|YEG|6/15/2014 17:50:00|$730.00");
		flightDetails.add("YYZ|6/13/2014 7:00:00|YVR|6/13/2014 9:00:00|$648.00");
		flightDetails.add("MIA|6/22/2014 6:50:00|ORD|6/22/2014 9:02:00|$576.00");
		flightDetails.add("YYC|6/23/2014 14:15:00|YYZ|6/23/2014 21:59:00|$573.00");
		flightDetails.add("YYZ|6/15/2014 18:00:00|YVR|6/15/2014 20:00:00|$698.00");
		flightDetails.add("LAS|6/16/2014 8:11:00|YYZ|6/16/2014 19:28:00|$703.00");
		flightDetails.add("LHR|6/27/2014 16:40:00|BOS|6/27/2014 18:50:00|$1616.00");
		flightDetails.add("MSY|6/19/2014 14:55:00|YUL|6/19/2014 23:24:00|$645.00");
		flightDetails.add("YYZ|6/22/2014 12:00:00|YYC|6/22/2014 14:09:00|$630.00");
		flightDetails.add("LAS|6/15/2014 9:54:00|LAX|6/15/2014 11:05:00|$286.00");
		flightDetails.add("YYC|6/30/2014 9:30:00|YYZ|6/30/2014 17:05:00|$535.00");
		return flightDetails;
	}
	
	public List<FlightDetailsProvider_3> getFlightDetailsWithOriginDeparture(String origin, String destination){
		
		List<FlightDetailsProvider_3> flightDetailsOriginDep = new ArrayList<FlightDetailsProvider_3>();
		List<String> flightDetailsList = fetchFlightDetailsListProvider3();
		if(null != flightDetailsList && flightDetailsList.size() > 0){
		for(String flightDetail : flightDetailsList){
			
			String[] flightDetailsSplit = flightDetail.split("\\|");
			//FlightDetailsProvider_3 dataFlightDetail = new FlightDetailsProvider_3(flightDetailsSplit[0], flightDetailsSplit[1], flightDetailsSplit[2], flightDetailsSplit[3], flightDetailsSplit[4]);
			
			if(flightDetailsSplit[0].equalsIgnoreCase(origin) && flightDetailsSplit[2].equalsIgnoreCase(destination)){
				flightDetailsOriginDep.add(new FlightDetailsProvider_3(flightDetailsSplit[0], flightDetailsSplit[1], flightDetailsSplit[2], flightDetailsSplit[3], flightDetailsSplit[4]));
			}
			
		}
		}
		return flightDetailsOriginDep;
	}

}
