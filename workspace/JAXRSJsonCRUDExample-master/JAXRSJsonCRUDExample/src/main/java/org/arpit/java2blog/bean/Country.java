package org.arpit.java2blog.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Country{
	@Column
	int id;
	@Column
	long population;
	@Column
	String countryName;	
	
	public Country() {
		super();
	}
	public Country(int i, String countryName,long population) {
		super();
		this.id = i;
		this.countryName = countryName;
		this.population=population;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String name) {
		this.countryName = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
	 
	
}