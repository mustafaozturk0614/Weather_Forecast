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
public class Wind {
	private double speed;
	private double deg;
	private double gust;
}
