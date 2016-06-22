package org.arpit.java2blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.arpit.java2blog.bean.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;

import com.arpit.java2blog.hibernate.dao.SessionUtil;
import com.sun.xml.bind.v2.model.core.ID;

import javassist.bytecode.Descriptor.Iterator;

public class CountryDao {

	private static Class<?> country;

	public static boolean addCountry(Country c) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Country country = new Country();

		country.setId(c.getId());
		country.setCountryName(c.getCountryName());
		country.setPopulation(c.getPopulation());

		session.save(country);
		tx.commit();
		session.close();
		return true;

	}

	public static boolean udpateCountry(Country c) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Country country = new Country();

		country.setId(c.getId());
		country.setCountryName(c.getCountryName());
		country.setPopulation(c.getPopulation());

		session.update(country);
		tx.commit();
		session.close();
		return true;

	}

	public static boolean deleteCountry(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Country country = new Country();
		country.setId(id);
		session.delete(country);
		tx.commit();
		session.close();
		return true;

	}

	public static Country getCountry(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Country country = new Country();
		country.setId(id);
		country = (Country) session.get(Country.class, id);
		tx.commit();
		session.close();
		return country;

	}

	public static List<Country> getallCountries() {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		 List <Country> c = session.createQuery("FROM Country").list(); 
//         for (Iterator iterator = 
//                          c.iterator(); iterator.hasNext();){
//           Country country = (Country) iterator.next(); 
		tx.commit();
		session.close();
		return c;

	}
	
	
	
	
	
	
	
	
	
	
	
}
