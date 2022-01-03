package com.bilgeadam.boost.java.weatherforecast.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherUtil {
	
	public static String getWeatherData(double lat, double lon) {
		String url = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon
				+ "&units=metric&lang=tr&appid=246a2bf08c730aed2f8a547f8d85943a";
		String retVal = "";
		
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				retVal += inputLine;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	/**
	 * Verilen bilgiler dahilinde 3er saatlik aral�klala yap�lm�� 5 adet hava
	 * tahminini geri döner
	 * 
	 * @param ilce Bir �ehrin il�esinin ad�
	 * @param il   �ehir ad�
	 * @param ulke IOS �lke k�sa kodlar�, T�rkiye i�in TR
	 * @return
	 */
	
	public static String getForecastData(String city) {
		String url = "https://api.openweathermap.org/data/2.5/forecast?&q=" + city.toLowerCase()
				+ "&units=metric&cnt=5&appid=246a2bf08c730aed2f8a547f8d85943a";
		String retVal = "";
		
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				retVal += inputLine;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	/**
	 * Verilen bilgiler dahilinde bir il�enin enlem ve boylam bilgilerine ula�mak
	 * için kullan�l�r
	 * 
	 * @param ilce Bir �ehrin il�esinin ad�
	 * @param il   �ehir ad�
	 * @param ulke IOS �lke k�sa kodlar�, T�rkiye i�in TR
	 * @return
	 */
	public static String getDirectData(String ilce, String il, String ulke) {
		String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + ilce + "," + il + "," + ulke
				+ "&limit=1&appid=246a2bf08c730aed2f8a547f8d85943a";
		String retValue = "";
		
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				retValue += inputLine;
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retValue;
	}
}
