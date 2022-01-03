package com.bilgeadam.boost.java.weatherforecast.business.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Data

@ToString
@Entity
@Table(name = "weather_data")
public class WeatherData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;
	@Temporal(TemporalType.DATE)
	private Date timestamp;
	private double temp;
	@ManyToOne
	private City city;
	
	public WeatherData(Date timestamp, double temp) {
		super();
		this.timestamp = timestamp;
		this.temp = temp;
		
	}
}
