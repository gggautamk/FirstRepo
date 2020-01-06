package org.gautam.restapp.searchFlight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchFlightServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String contextRoot = "messanger";

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String pathInfo = req.getPathInfo(); // /{value}/test
		String[] pathParts = pathInfo.split("/");
		String origin = pathParts[1];
		String destination = pathParts[2];

		SortedSet<FlightDetails> sortedSetList = null;
		Set<FlightDetails> flightDetailList = null;

		PrintWriter writer = resp.getWriter();
		StringBuffer sb = new StringBuffer();

		sb.append("<html><body>");
		sb.append("<h1>Flight Details for Origin - '" + origin + "' and Destination - '" + destination + "' .</h1>");
		flightDetailList = new SearchFlightHandler().fetchAllData(getListOFProviders(), contextRoot,origin, destination);
		if (null != flightDetailList && flightDetailList.size() > 0) {
			sortedSetList = new TreeSet<FlightDetails>(flightDetailList);

			for (FlightDetails flightDetails : sortedSetList) {

				sb.append("<h3> " + origin + " -->  " + destination + "  ( " + flightDetails.getDepartureTime()
						+ " --> " + flightDetails.getDepartureTime() + "  )  -  $" + flightDetails.getPrice() + "</h3>");

			}

		} else
			sb.append("<h3> No Flights found for " + origin + " -->  " + destination + "</h3>");
		sb.append("</body></html>");
		writer.println(sb.toString());

	}
	
	public static List<String> getListOFProviders(){
		
		List<String> listOfProviders = new ArrayList<String>();
		listOfProviders.add("Provider1");
		listOfProviders.add("Provider2");
		listOfProviders.add("Provider3");
		return listOfProviders;
	}
	
}
