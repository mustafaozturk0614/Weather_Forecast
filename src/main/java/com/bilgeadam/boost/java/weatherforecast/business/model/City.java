package com.bilgeadam.boost.java.weatherforecast.business.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeExclude;
import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Data;
import lombok.ToString;

@Data

@ToString
@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	private String name;
	private long population;
	private String code;
	private double langitude;
	private double longitude;
	private double altitude;
	@ToStringExclude
	@HashCodeExclude
	@ManyToOne
	private Country country;
	@OneToMany(mappedBy = "city")
	private List<WeatherData> data;
	
	public void addWeatherData(WeatherData data) {
		if (this.data == null) {
			this.data = new ArrayList<>();
		}
		this.data.add(data);
	}
	
	public City(String name, long population, String code, double langitude, double longitude, double altitude) {
		super();
		this.name = name;
		this.population = population;
		this.code = code;
		this.langitude = langitude;
		this.longitude = longitude;
		this.altitude = altitude;
		
	}
}
