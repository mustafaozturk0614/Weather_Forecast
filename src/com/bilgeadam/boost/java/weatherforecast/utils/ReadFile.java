package com.bilgeadam.boost.java.weatherforecast.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {
	
	public static void ReadCities() {
		String pathname = "E:\\file\\city.txt";
		File file = new File(pathname);
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
