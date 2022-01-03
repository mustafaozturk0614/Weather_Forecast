package com.bilgeadam.boost.java.weatherforecast.business.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Data;
import lombok.ToString;

@Data

@ToString
@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	private String name;
	private String code;
	private long population;
	@ToStringExclude
	@HashCodeExclude
	@OneToOne
	private City capital;
	@ToStringExclude
	@HashCodeExclude
	@OneToMany(mappedBy = "country")
	private List<City> cities;
	
	public void addCity(City city) {
		if (this.cities == null) {
			this.cities = new ArrayList<>();
		}
		this.cities.add(city);
	}
	
	public Country(String name, String code, long population, City capital) {
		super();
		this.name = name;
		this.code = code;
		this.population = population;
		this.capital = capital;
		
	}
}
