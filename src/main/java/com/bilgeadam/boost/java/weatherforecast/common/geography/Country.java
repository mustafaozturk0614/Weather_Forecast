package com.bilgeadam.boost.java.weatherforecast.common.geography;

import java.util.ArrayList;

import org.bson.codecs.pojo.annotations.BsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Country {
	@BsonProperty(value = "country_name") // s�n�f de�i�keni ile veritaban� collection'�ndaki key/value pair'in key
											// ad�n� belirliyor
	private String name;
	@BsonProperty(value = "capital")
	private City capital;
	@BsonProperty(value = "telcode")
	private int telCode;
	@BsonProperty(value = "country_code")
	private String countryCode;
	@BsonProperty(value = "cities")
	private ArrayList<City> cities;
	@BsonProperty(value = "country_population")
	private long population;
}
