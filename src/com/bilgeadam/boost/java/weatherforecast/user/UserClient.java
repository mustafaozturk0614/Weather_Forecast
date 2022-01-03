package com.bilgeadam.boost.java.weatherforecast.user;

import java.util.ArrayList;
import java.util.Scanner;

import com.bilgeadam.boost.java.weatherforecast.common.geography.City;
import com.bilgeadam.boost.java.weatherforecast.rawdata.WeatherClient;
import com.bilgeadam.boost.java.weatherforecast.utils.Logging;
import com.bilgeadam.boost.java.weatherforecast.utils.MongoUtilities;

public class UserClient implements Runnable {
	private static final String NAME = UserClient.class.getSimpleName();
	private Scanner scan;
	
	@Override
	public void run() {
		Logging.getInstance().logInfo(UserClient.NAME + " is up and runnig");
		
		this.showMenu();
	}
	
	private void showMenu() {
		scan = new Scanner(System.in);
		boolean cont = true;
		while (cont) {
			String country = this.selectCountry();
			City city = this.selectCity(country);
			this.startWeatherClient(city);
			System.out.print("\nDevam etmek istiyor musunuz (0=hayır)?");
			int sel = scan.nextInt();
			scan.nextLine();
			cont = sel != 0;
		}
		scan.close();
	}
	
	private void startWeatherClient(City city) {
		WeatherClient weatherClient = new WeatherClient(city);
		new Thread(weatherClient, weatherClient.getClass().getSimpleName()).start();
	}
	
	private City selectCity(String country) {
		ArrayList<City> cities = MongoUtilities.INSTANCE.getCities(country);
		
		System.out.println("\n HAngi ŞEhirin DEğerlerini almak istiyorsunuz:");
		int i = 1;
		for (City city : cities) {
			System.out.println(i++ + " " + city.getName());
		}
		
		int sel = scan.nextInt();
		scan.nextLine();
		Logging.getInstance().logInfo("SELECTED CITY: " + cities.get(sel - 1));
		return cities.get(sel - 1);
	}
	
	private String selectCountry() {
		System.out.print("Lütfen Ülke Seçiniz:" + "");
		Iterable<String> countries = MongoUtilities.INSTANCE.getCountries();
		int i = 1;
		for (String country : countries) {
			System.out.println(i++ + " " + country);
		}
		int sel = scan.nextInt();
		scan.nextLine();
		Logging.getInstance().logInfo("SELECTED COUNTRY: " + MongoUtilities.INSTANCE.getCountries().get(sel - 1));
		return MongoUtilities.INSTANCE.getCountries().get(sel - 1);
	}
	
	public String getName() {
		return UserClient.NAME;
	}
}
