package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.arpit.java2blog.bean.Country;
import org.arpit.java2blog.dao.CountryDao;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class CountryService {

	static HashMap<Integer,Country> countryIdMap=getCountryIdMap();

	public CountryService() {
		super();
	}

	public List<Country> getAllCountries()
	{
		return CountryDao.getAllCountries();
	}

	public Country getCountry(int id)
	{
		
		return CountryDao.getCountry(id);
	}
	
	public boolean addCountry(Country country)
	{
		return CountryDao.addCountry(country);
	}
	
	public boolean updateCountry(Country country)
	{
		return CountryDao.udpateCountry(country);

	}
	public  boolean deleteCountry(int id)
	{
		return CountryDao.deleteCountry(id);
	}

	public static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}


}
