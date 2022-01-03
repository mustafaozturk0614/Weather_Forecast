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
public class Liste {
	private String id;
	private List<Weather> weather;
	private double dt;
	private Main main;
	private long visibility;
	private Wind wind;
	private Cloud clouds;
	private MoreData sys;
	private String dt_txt;
	private double pop;
	private String name;
	private int cod;
	
}
