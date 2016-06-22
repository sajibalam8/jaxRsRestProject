package org.arpit.java2blog.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arpit.java2blog.bean.Country;
import org.arpit.java2blog.service.CountryService;

@Path("/countries")
public class CountryController {

	CountryService countryService = new CountryService();
	//system.out.println("test");

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addCountry(Country country) {
		countryService.addCountry(country);

		return "Country had been successfully added";
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCountry(Country country) {
		countryService.updateCountry(country);
		return "Country had been successfully updated";

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCountry(@PathParam("id") int id) {
		countryService.deleteCountry(id);
		return "Country had been successfully deleted";

	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountry(@PathParam("id") int id) {
		return countryService.getCountry(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getAllCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}
}
