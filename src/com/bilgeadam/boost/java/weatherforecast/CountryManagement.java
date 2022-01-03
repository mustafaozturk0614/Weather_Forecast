package com.bilgeadam.boost.java.weatherforecast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.bilgeadam.boost.java.weatherforecast.common.geography.City;
import com.bilgeadam.boost.java.weatherforecast.common.geography.Country;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CountryManagement {
	private MongoClient client;
	private MongoDatabase database;
	private List<Country> countries;
	
	public CountryManagement() {
		this.client = new MongoClient("localhost", 27017);
		this.database = client.getDatabase("mongoDB");
		this.countries = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		CountryManagement countryManager = new CountryManagement();
		countryManager.init();
		countryManager.insertData();
		
	}
	
	private void insertData() {
		
		PojoCodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(codecProvider));
		
		MongoCollection<Country> countryDocuments = database //
				.withCodecRegistry(pojoCodecRegistry) //
				.getCollection("countries", Country.class); //
		countryDocuments.insertMany(countries);
		
		// countryDocuments.updateMany(Filters.or(Filters.eq("cities.city_name",
		// "Ankara"), Filters.eq("capital.city_name", "Ankara")),
		// Updates.set("city_population", 5_639_076*2));
	}
	
	private void init() {
		String pathname = "E:\\file\\city.txt";
		String pathname2 = "E:\\file\\tr.txt";
		File file = new File(pathname);
		File file2 = new File(pathname2);
		String line = "";
		String line2 = "";
		ArrayList<City> cities = new ArrayList<>();
		TreeMap<String, String> information = new TreeMap();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
			while ((line = bufferedReader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, " ");
				
				tokenizer.nextToken();
				String name = tokenizer.nextToken();
				String latString = tokenizer.nextToken();
				String lotString = tokenizer.nextToken();
				information.put(name, latString + "-" + lotString);
				
			}
			int i = 1;
			while ((line2 = bufferedReader2.readLine()) != null) {
				
				String code;
				String latlon = information.get(line2.toUpperCase());
				String[] array = new String[2];
				StringTokenizer tokenizer2 = new StringTokenizer(latlon, "-");
				array = latlon.split("-");
				if (i < 10) {
					code = "0" + i;
					i++;
				} else {
					code = i + "";
					i++;
				}
				Double latitude = Double.parseDouble((tokenizer2.nextToken()).replace(",", "."));
				Double longitude = Double.parseDouble(tokenizer2.nextToken().replace(",", "."));
				City city = City.builder().name(line2).latitude(latitude).longitude(longitude).cityCode(code).build();
				cities.add(city);
				
			}
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Country country = Country.builder().countryCode("TR").name("Türkiye").population(84_342_846).cities(cities)
				.telCode(90).build();
		this.countries.add(country);
		this.countries.add(Country.builder().capital(City.builder().name("Berlin").build()).name("Almanya").build());
		
	}
	
}
