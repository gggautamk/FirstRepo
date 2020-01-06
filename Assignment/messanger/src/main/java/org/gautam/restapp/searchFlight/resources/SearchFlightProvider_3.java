package org.gautam.restapp.searchFlight.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gautam.restapp.searchFlight.model.FlightDetailsProvider_3;
import org.gautam.restapp.searchFlight.service.SearchFlightServiceProvider_3;

@Path("/Provider3")
public class SearchFlightProvider_3 {
	
	SearchFlightServiceProvider_3 provider3Data = new SearchFlightServiceProvider_3();
	
	@GET
	@Path("/{origin}/{destination}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightDetailsProvider_3> getFlightDetails(@PathParam("origin") String origin, @PathParam("destination") String destination) {
		return provider3Data.getFlightDetailsWithOriginDeparture(origin, destination);
	}


}
