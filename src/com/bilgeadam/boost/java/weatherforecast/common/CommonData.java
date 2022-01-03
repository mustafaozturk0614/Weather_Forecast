package com.bilgeadam.boost.java.weatherforecast.common;

import com.bilgeadam.boost.java.weatherforecast.common.geography.City;

import lombok.Getter;
import lombok.Setter;

public class CommonData {
	private static CommonData instance;
	
	@Getter
	@Setter
	private City selectedCity;
	
	private CommonData() {
		CommonData.instance = null;
	}
	
	public static CommonData getInstance() {
		if (CommonData.instance == null) {
			CommonData.instance = new CommonData();
		}
		return CommonData.instance;
	}
}
