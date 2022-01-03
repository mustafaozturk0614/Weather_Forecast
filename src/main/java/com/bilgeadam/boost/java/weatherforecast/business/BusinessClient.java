package com.bilgeadam.boost.java.weatherforecast.business;

import java.util.List;

import com.bilgeadam.boost.java.weatherforecast.common.weather.CurrentWeather;
import com.bilgeadam.boost.java.weatherforecast.common.weather.ForeCastData;
import com.bilgeadam.boost.java.weatherforecast.utils.Logging;
import com.bilgeadam.boost.java.weatherforecast.utils.MongoUtilities;

public class BusinessClient implements Runnable {
	
	@Override
	public void run() {
		Logging.getInstance().logInfo(BusinessClient.class.getSimpleName() + " is up and runnig");
		
	}
	
	public static void main(String[] args) {
		
		List<CurrentWeather> arrayList = MongoUtilities.INSTANCE.getWeatherData();
		List<ForeCastData> arrayList2 = MongoUtilities.INSTANCE.getForecastData();
		System.out.println("*******************************");
		for (Object object : arrayList) {
			System.out.println(object);
			
		}
		System.out.println("*******************************");
		for (Object object : arrayList2) {
			System.out.println(object);
			
		}
		
	}
}
