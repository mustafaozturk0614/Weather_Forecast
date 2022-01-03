package com.bilgeadam.boost.java.weatherforecast.utils;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.bilgeadam.boost.java.weatherforecast.common.geography.City;
import com.bilgeadam.boost.java.weatherforecast.common.geography.Country;
import com.bilgeadam.boost.java.weatherforecast.common.weather.CurrentWeather;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public enum MongoUtilities { // singleton pattern'�n�n enum olarak implemente edilmi� �ekli
	INSTANCE;
	
	private MongoClient client;
	private MongoDatabase database;
	private PojoCodecProvider codecProvider;
	private CodecRegistry pojoCodecRegistry;
	private MongoCollection<Country> countries;
	private MongoCollection<CurrentWeather> weatherData;
	
	private MongoUtilities() {
		Logging.getInstance().logInfo(MongoUtilities.class.getSimpleName() + " --> " + "Calling constrator");
		
		initDatabase();
	}
	
	private void initDatabase() {
		Logging.getInstance().logInfo(MongoUtilities.class.getSimpleName() + " --> " + "init database and read data");
		
		this.client = new MongoClient("localhost", 27017);
		this.database = this.client.getDatabase("mongoDB");
		this.codecProvider = PojoCodecProvider.builder().automatic(true).build();
		this.pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(this.codecProvider));
		countries = database.withCodecRegistry(pojoCodecRegistry).getCollection("countries", Country.class);
	}
	
	private MongoCollection<Country> getCountryCollection() {
		Logging.getInstance().logInfo(MongoUtilities.class.getSimpleName() + " --> " + "Retrieving country collection");
		
		if (this.database == null)
			this.initDatabase();
		return this.countries;
	}
	
	public List<String> getCountries() {
		List<String> retVal = new ArrayList<>();
		
		Iterable<Country> iter = this.getCountryCollection().find();
		iter.forEach(country -> retVal.add(country.getName()));
		return retVal;
	}
	
	public ArrayList<City> getCities(String country) {
		Bson filter = eq("country_name", country); // Filters.eq(...) yerine sadece eq(...) yazmak i�in static import
													// kullan
		return this.getCountryCollection().find(filter).first().getCities(); // this.getCountryCollection().find(filter)
																				// bir collection d�ner
																				// collection'�n ilk ��esini almak i�in
																				// first kullan�yoruz
	}
	
	public void parseCurrentWeatherJSON(String jsonString) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CurrentWeather currentWeather = null;
		try {
			currentWeather = mapper.readValue(jsonString, CurrentWeather.class);
			currentWeather.setId(UUID.randomUUID().toString());
		} catch (Exception e) {
			Logging.getInstance().logError(e.getMessage());
		}
		weatherData = database.withCodecRegistry(pojoCodecRegistry).getCollection("weatherdata", CurrentWeather.class);
		weatherData.insertOne(currentWeather);
		System.out.println("Database güncelllendi");
	}
	
	public void parseForecastWeatherJSON(String jsonString) {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CurrentWeather currentWeather = null;
		
	}
}
