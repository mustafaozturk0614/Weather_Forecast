package com.bilgeadam.boost.java.weatherforecast;
import com.bilgeadam.boost.java.weatherforecast.business.BusinessClient;
import com.bilgeadam.boost.java.weatherforecast.user.UserClient;
import com.bilgeadam.boost.java.weatherforecast.utils.Logging;

public class WeatherManagement {
	
	public static void main(String[] args) {
		Logging.getInstance().logInfo("Weather Management System is startin...");
		
		BusinessClient businessClient = new BusinessClient();
		new Thread(businessClient, businessClient.getClass().getSimpleName()).start();
		
		UserClient userClient = new UserClient();
		new Thread(userClient, userClient.getName()).start(); // thread �al��t�rma
		Logging.getInstance().logInfo("Weather Management System has started");
	}
}
