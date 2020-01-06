package org.gautam.restapp.searchFlight.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gautam.restapp.searchFlight.model.FlightDetailsProvider_1;
import org.gautam.restapp.searchFlight.service.SearchFlightServiceProvider_1;

@Path("/Provider1")
public class SearchFlightProvider_1 {
	
	SearchFlightServiceProvider_1 provider1Data = new SearchFlightServiceProvider_1();
	
	@GET
	@Path("/{origin}/{destination}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDetailsProvider_1> getFlightDetails(@PathParam("origin") String origin, @PathParam("destination") String destination) {
		return provider1Data.getFlightDetailsWithOriginDeparture(origin, destination);
	}	
	
	
}
