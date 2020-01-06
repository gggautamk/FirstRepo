package org.gautam.restapp.searchFlight.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gautam.restapp.searchFlight.model.FlightDetailsProvider_2;
import org.gautam.restapp.searchFlight.service.SearchFlightServiceProvider_2;

@Path("/Provider2")
public class SearchFlightProvider_2 {
	
	SearchFlightServiceProvider_2 provider2Data = new SearchFlightServiceProvider_2();
	
	@GET
	@Path("/{origin}/{destination}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDetailsProvider_2> getFlightDetails(@PathParam("origin") String origin, @PathParam("destination") String destination) {
		return provider2Data.getFlightDetailsWithOriginDeparture(origin, destination);
	}

}
