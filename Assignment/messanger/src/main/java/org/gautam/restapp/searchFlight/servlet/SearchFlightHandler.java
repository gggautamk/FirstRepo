package org.gautam.restapp.searchFlight.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchFlightHandler {
	
	public Set<FlightDetails> fetchAllData(List<String> listOfProviders,String contextRoot, String origin, String destination){
		
		Set<FlightDetails> flightDetailList = new HashSet<FlightDetails>();
		
		for(String providername : listOfProviders){
			
			getResponsefromProviders(providername,contextRoot, origin, destination, flightDetailList);
		}
		
		
		return flightDetailList;
	}

/*	private void fillOutPutDataToSet(String providerName, String output, Set<FlightDetails> flightDetailList) {
		
		final JSONObject jsonobj = new JSONObject(output.replace("[", "{flightDeatils:[").replace("]", "]}"));
		final JSONArray jsonobjdata = jsonobj.getJSONArray("flightDeatils");
		
		for (int i = 0; i < jsonobjdata.length(); ++i) {
		      final JSONObject flightDetail = jsonobjdata.getJSONObject(i);
		      try {
				flightDetailList.add(new FlightDetails(providerName, flightDetail.getString("origin"), flightDetail.getString("departureTime"), flightDetail.getString("destination"), flightDetail.getString("destinationTime"), Double.parseDouble(flightDetail.getString("price").replace("$", ""))));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
	}*/

	private void getResponsefromProviders(String providername, String contextRoot, String origin, String destination, Set<FlightDetails> flightDetailList) {
		
		
		
		try {
			String output="";
			URL url = new URL("http://localhost:8080/"+contextRoot+"/searchFlightByProviders/"+providername+"/"+origin+"/"+destination);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				if(null != output && !"".equalsIgnoreCase(output) && !"[]".equalsIgnoreCase(output)){
				final JSONObject jsonobj = new JSONObject(output.replace("[", "{flightDeatils:[").replace("]", "]}"));
				final JSONArray jsonobjdata = jsonobj.getJSONArray("flightDeatils");
				
				for (int i = 0; i < jsonobjdata.length(); ++i) {
				      final JSONObject flightDetail = jsonobjdata.getJSONObject(i);
				      try {
						flightDetailList.add(new FlightDetails(providername, flightDetail.getString("origin"), flightDetail.getString("departureTime"), flightDetail.getString("destination"), flightDetail.getString("destinationTime"), Double.parseDouble(flightDetail.getString("price").replace("$", ""))));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (JSONException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

	}

}
