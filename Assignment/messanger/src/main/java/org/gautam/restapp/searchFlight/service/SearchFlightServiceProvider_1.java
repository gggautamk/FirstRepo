package org.gautam.restapp.searchFlight.service;

import java.util.ArrayList;
import java.util.List;

import org.gautam.restapp.searchFlight.model.FlightDetailsProvider_1;

public class SearchFlightServiceProvider_1 {
	
	//HarCoded data in realTime to be fetched from DB
	public static List<String> fetchFlightDetailsListProvider1(){
		
		List<String> flightDetails = new ArrayList<String>();
		flightDetails.add("LAS,6/23/2014 13:30:00,LAX,6/23/2014 14:40:00,$151.00");
		flightDetails.add("YYZ,6/15/2014 6:45:00,YYC,6/15/2014 8:54:00,$578.00");
		flightDetails.add("MIA,6/23/2014 19:40:00,ORD,6/23/2014 21:45:00,$532.00");
		flightDetails.add("YYC,6/12/2014 11:00:00,YVR,6/12/2014 11:24:00,$379.00");
		flightDetails.add("LHR,6/21/2014 11:05:00,BOS,6/21/2014 17:06:00,$975.00");
		flightDetails.add("YVR,6/18/2014 9:10:00,YYZ,6/18/2014 19:47:00,$1093.00");
		flightDetails.add("LAX,6/19/2014 8:45:00,YYC,6/19/2014 12:45:00,$356.00");
		flightDetails.add("MIA,6/20/2014 7:45:00,ORD,6/20/2014 12:36:00,$422.00");
		flightDetails.add("LAS,6/23/2014 13:30:00,LAX,6/23/2014 14:40:00,$151.00");
		return flightDetails;
	}
	
	public List<FlightDetailsProvider_1> getFlightDetailsWithOriginDeparture(String origin, String destination){
		
		List<FlightDetailsProvider_1> flightDetailsOriginDep = new ArrayList<FlightDetailsProvider_1>();
		List<String> flightDetailsList = fetchFlightDetailsListProvider1();
		if(null != flightDetailsList && flightDetailsList.size() > 0){
		for(String flightDetail : flightDetailsList){
			
			String[] flightDetailsSplit = flightDetail.split(",");
			//FlightDetailsProvider_1 dataFlightDetail = new FlightDetailsProvider_1(flightDetailsSplit[0], flightDetailsSplit[1], flightDetailsSplit[2], flightDetailsSplit[3], flightDetailsSplit[4]);
			
			if(flightDetailsSplit[0].equalsIgnoreCase(origin) && flightDetailsSplit[2].equalsIgnoreCase(destination)){
				flightDetailsOriginDep.add(new FlightDetailsProvider_1(flightDetailsSplit[0], flightDetailsSplit[1], flightDetailsSplit[2], flightDetailsSplit[3], flightDetailsSplit[4]));
			}
			
		}
		}
		return flightDetailsOriginDep;
	}

}
