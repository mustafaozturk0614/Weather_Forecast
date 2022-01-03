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
public class Main {
	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private double pressure;
	private int humidity;
	
	private double sea_level;
	private double grnd_level;
	
	private double temp_kf;
}
