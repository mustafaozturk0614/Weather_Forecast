package com.bilgeadam.boost.java.weatherforecast.rawdata;

import com.bilgeadam.boost.java.weatherforecast.common.geography.City;
import com.bilgeadam.boost.java.weatherforecast.utils.Logging;
import com.bilgeadam.boost.java.weatherforecast.utils.MongoUtilities;
import com.bilgeadam.boost.java.weatherforecast.utils.WeatherUtil;

import lombok.Getter;

public class WeatherClient implements Runnable {
	@Getter
	private City city;
	
	public WeatherClient(City city) {
		this.city = city;
	}
	
	@Override
	public void run() {
		Logging.getInstance().logInfo(this.getName() + " is up and runnig");
		try {
			while (true) {
				String actWeather = WeatherUtil.getWeatherData(this.city.getLatitude(), this.city.getLongitude());
				
				String forecastWeather = WeatherUtil.getForecastData(city.getName());
				MongoUtilities.INSTANCE.parseCurrentWeatherJSON(actWeather);
				MongoUtilities.INSTANCE.parseForecastWeatherJSON(forecastWeather);
				Thread.sleep(300000);
			}
		} catch (InterruptedException ex) {
			Logging.getInstance().logError(this.getClass().getSimpleName() + " --> " + ex.getMessage());
		}
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}
