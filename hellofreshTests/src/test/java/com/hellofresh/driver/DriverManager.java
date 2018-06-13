package com.hellofresh.driver;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.hellofresh.utils.HelperManager;


/**
 * DriverManager class to Read properties from the configuration file.
 **/

public class DriverManager {
	protected static String relativePath;
	protected static String configPath;
	protected static String browserName;
	protected static String desktopUrl;

	public static String getDesktopUrl() {
		return desktopUrl;
	}

	public static String getBrowserName() {
		return browserName;
	}

	public static String getConfigPath() {
		return configPath;
	}

	public static String getRelativePath() {
		return relativePath;
	}

	/**
	 * This method retrieves all properties from the StandAloneEnvProperties
	 * file
	 **/
	protected static void retrieveEnvProperties() {
		configPath = "./src/test/resources/configuration/config.properties";

		Properties prop = HelperManager.getProperties(configPath);

		Set<Object> set = prop.keySet();

		Iterator<Object> it = set.iterator();

		for (int i = 0; i < set.size(); i++) {
			String key = (String) it.next();

			if (key.equalsIgnoreCase("desktopUrl")) {
				desktopUrl = prop.getProperty(key);
				System.out.println("URL is: " + desktopUrl);
			} else
				continue;
		}
	}

	/**
	 * This method selects the sheet based on platform type
	 **/
	protected static void createXML() throws Exception {
		//if (type.equalsIgnoreCase("Desktop")) {
			//if (runOn.equalsIgnoreCase("grid")) {
				//XMLUtilityManager.createXmlForGridConfig("TestScriptsWeb", browserName1, browserName2, browserName3);
			//} else if (runOn.equalsIgnoreCase("StandAlone")) {
				//XMLUtilityManager.createXmlForStandAloneConfig("TestScriptsWeb", browserName);
			//}
		//}
	}

}