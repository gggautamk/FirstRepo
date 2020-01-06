package org.gautam.restapp.searchFlight.service;

import java.util.ArrayList;
import java.util.List;

import org.gautam.restapp.searchFlight.model.FlightDetailsProvider_2;


public class SearchFlightServiceProvider_2 {
	
	//HarCoded data in realTime to be fetched from DB
	public static List<String> fetchFlightDetailsListProvider2(){
		
		List<String> flightDetails = new ArrayList<String>();
		flightDetails.add("JFK,6-21-2014 17:55:00,YEG,6-21-2014 23:23:00,$589.00");
		flightDetails.add("LAS,6-22-2014 9:45:00,YYZ,6-22-2014 21:20:00,$549.00");
		flightDetails.add("YVR,6-23-2014 9:20:00,YYZ,6-23-2014 15:22:00,$1122.00");
		flightDetails.add("MSY,6-19-2014 5:55:00,YUL,6-19-2014 10:58:00,$480.00");
		flightDetails.add("YYZ,6-26-2014 12:00:00,YYC,6-26-2014 14:09:00,$630.00");
		flightDetails.add("LAX,6-19-2014 11:00:00,YYC,6-19-2014 17:45:00,$543.00");
		flightDetails.add("YYC,6-23-2014 12:40:00,YYZ,6-23-2014 14:54:00,$541.00");
		flightDetails.add("MIA,6-23-2014 19:40:00,ORD,6-23-2014 21:45:00,$532.00");
		flightDetails.add("YVR,6-23-2014 22:10:00,YYZ,6-24-2014 2:22:00,$1151.00");
		flightDetails.add("LAS,6-16-2014 8:11:00,YYZ,6-16-2014 19:28:00,$703.00");
		flightDetails.add("LAX,6-21-2014 8:55:00,YYC,6-21-2014 15:10:00,$577.00");
		flightDetails.add("YYZ,6-15-2014 7:00:00,YVR,6-15-2014 9:00:00,$647.00");
		flightDetails.add("LHR,6-19-2014 6:30:00,BOS,6-19-2014 12:42:00,$1243.00");
		return flightDetails;
	}
	
	public List<FlightDetailsProvider_2> getFlightDetailsWithOriginDeparture(String origin, String destination){
		
		List<FlightDetailsProvider_2> flightDetailsOriginDep = new ArrayList<FlightDetailsProvider_2>();
		List<String> flightDetailsList = fetchFlightDetailsListProvider2();
		if(null != flightDetailsList && flightDetailsList.size() > 0){
		for(String flightDetail : flightDetailsList){
			
			String[] flightDetailsSplit = flightDetail.split(",");
			//FlightDetailsProvider_2 dataFlightDetail = new FlightDetailsProvider_2(flightDetailsSplit[0], flightDetailsSplit[1], flightDetailsSplit[2], flightDetailsSplit[3], flightDetailsSplit[4]);
			
			if(flightDetailsSplit[0].equalsIgnoreCase(origin) && flightDetailsSplit[2].equalsIgnoreCase(destination)){
				flightDetailsOriginDep.add(new FlightDetailsProvider_2(flightDetailsSplit[0], flightDetailsSplit[1], flightDetailsSplit[2], flightDetailsSplit[3], flightDetailsSplit[4]));
			}
			
		}
		}
		return flightDetailsOriginDep;
	}

}
