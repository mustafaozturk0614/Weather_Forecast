package com.bilgeadam.boost.java.weatherforecast.common.weather;

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
public class Coord {
	
	private double lat;
	
	private double lon;
	
}
