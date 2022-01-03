package com.bilgeadam.boost.java.weatherforecast.common.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class City {
	
	private int id;
	String name;
	private Coord coord;
	private String sunrise;
	private String sunset;
	String country;
	private long timezone;
	
}
