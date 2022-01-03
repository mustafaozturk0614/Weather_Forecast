package com.bilgeadam.boost.java.weatherforecast.common.weather;

import java.util.List;

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
public class ForeCastData {
	private String id;
	private City city;
	private List<Liste> list;
	
}
