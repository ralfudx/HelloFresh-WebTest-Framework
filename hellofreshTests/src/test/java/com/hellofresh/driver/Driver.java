package com.hellofresh.driver;

import com.hellofresh.driver.DriverManager;
import com.hellofresh.utils.HelperManager;

/**
 * Driver class with main method
 **/
public class Driver extends DriverManager {
	
	/**
	 * Main method
	 **/
	public static void main(String args[]) throws Exception {
		relativePath = System.getProperty("user.dir");
		browserName = System.getProperty("browser");
		
		retrieveEnvProperties();
		//createXML();
		HelperManager.autoRunXml();
	}
}