package com.bilgeadam.boost.java.weatherforecast.business;

import java.util.Date;

import org.hibernate.Session;

import com.bilgeadam.boost.java.weatherforecast.business.model.City;
import com.bilgeadam.boost.java.weatherforecast.business.model.Country;
import com.bilgeadam.boost.java.weatherforecast.business.model.WeatherData;
import com.bilgeadam.boost.java.weatherforecast.utils.HibernateUtil;

public class BusinessTest {
	public static void main(String[] args) {
		
		WeatherData w1 = new WeatherData(new Date(), 15.3);
		WeatherData w2 = new WeatherData(new Date(), 25.3);
		
		City c1 = new City("Ankara", 500000, "06", 34.5, 35.6, 36.6);
		c1.addWeatherData(w1);
		c1.addWeatherData(w2);
		w1.setCity(c1);
		w2.setCity(c1);
		
		Country country = new Country("Türk", "TR", 56365356, c1);
		country.addCity(c1);
		
		c1.setCountry(country);
		
		Session session = HibernateUtil.getInstance().getOpenSession();
		session.getTransaction().begin();
		
		session.persist(country);
		session.save(c1);
		session.save(w2);
		session.save(w2);
		session.getTransaction().commit();
		
	}
	
}
