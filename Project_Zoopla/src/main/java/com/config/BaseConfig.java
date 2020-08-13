package com.config;


import java.io.FileInputStream;
import java.util.Properties;

public class BaseConfig {
	
	public static String getConfig(String key) throws Throwable {
		//config file location
		Properties prop = new Properties();
		String filePath = "./config.properties";// how to read config /note pad or text file?
		FileInputStream fis = new FileInputStream(filePath);
		//connection of both
		prop.load(fis);
		return prop.get(key).toString();  // or prop.getProperty(key)
	}

}
