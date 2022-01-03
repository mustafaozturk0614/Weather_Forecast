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
public class MainValues {
	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private double pressure;
	private int humidity;
}
