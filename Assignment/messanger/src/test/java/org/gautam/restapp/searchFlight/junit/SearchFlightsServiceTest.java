package org.gautam.restapp.searchFlight.junit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import junit.framework.AssertionFailedError;

public class SearchFlightsServiceTest {
	
	private static final String contextRoot = "messanger";
	
	private String origin = "LHR";
	private String destination = "BOS";
	
	@Test
	public void testProviders(){
		
		try{
			
		testForAllProviders(contextRoot, origin, destination);
		
		}catch(Exception e){
			
			new AssertionFailedError("Error occured while invoking Providers");
		}
		
	}
	
	@Test
	public void testSearchFlight(){
		
		try{
		
		testForSearchFlights(contextRoot, origin, destination);
		
		}catch(Exception e){
			
			new AssertionFailedError("Error occured while searching flights");
		}
	}
	
	
	private void testForAllProviders(String contextroot, String origin, String destination) throws IOException{
		
		for(String providerName : getListOFProviders()){
			
				URL url = new URL("http://localhost:8080/"+contextRoot+"/searchFlightByProviders/"+providerName+"/"+origin+"/"+destination);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				//Checking the response code to be 200
				assertEquals(conn.getResponseCode(), 200);

				conn.disconnect();

			
			
			
		}
		
	}
	
	
	private void testForSearchFlights(String contextroot, String origin, String destination) throws IOException{
		
		URL url = new URL("http://localhost:8080/"+contextRoot+"/searchFlights/"+origin+"/"+destination);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		//Checking the response code to be 200
		assertEquals(conn.getResponseCode(), 200);

		conn.disconnect();
		
	}
	
	public static List<String> getListOFProviders(){
		
		List<String> listOfProviders = new ArrayList<String>();
		listOfProviders.add("Provider1");
		listOfProviders.add("Provider2");
		listOfProviders.add("Provider3");
		return listOfProviders;
	}

}
