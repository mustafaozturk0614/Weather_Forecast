package com.bilgeadam.boost.java.weatherforecast.business;

import com.bilgeadam.boost.java.weatherforecast.utils.Logging;
import com.bilgeadam.boost.java.weatherforecast.utils.MongoUtilities;

public class BusinessClient implements Runnable {
	
	@Override
	public void run() {
		Logging.getInstance().logInfo(BusinessClient.class.getSimpleName() + " is up and runnig");
		MongoUtilities.INSTANCE.getWeatherData().forEach(System.out::println);
		
	}
}
