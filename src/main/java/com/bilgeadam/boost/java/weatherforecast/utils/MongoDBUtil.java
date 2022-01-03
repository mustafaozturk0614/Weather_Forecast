package com.bilgeadam.boost.java.weatherforecast.utils;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.bilgeadam.boost.java.weatherforecast.common.geography.Country;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
	private static MongoDBUtil instance;
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private PojoCodecProvider codecProvider;
	private CodecRegistry pojoCodecRegistry;
	private MongoCollection<Country> countries;
	
	private MongoDBUtil() {
	}
	
	public static MongoDBUtil getInstance() {
		if (instance == null)
			instance = new MongoDBUtil();
		return instance;
	}
	
	private void initDatabase() {
		this.mongoClient = new MongoClient("localhost", 27017);
		this.database = this.mongoClient.getDatabase("mongoDb");
		this.codecProvider = PojoCodecProvider.builder().automatic(true).build();
		this.pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(this.codecProvider));
		countries = database.withCodecRegistry(pojoCodecRegistry).getCollection("countries", Country.class);
	}
	
	public MongoCollection<Country> getCountries() {
		if (this.database == null)
			this.initDatabase();
		return this.countries;
	}
}
