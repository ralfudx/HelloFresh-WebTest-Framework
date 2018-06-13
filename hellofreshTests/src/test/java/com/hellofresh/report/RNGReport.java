package com.hellofresh.report;

import java.io.File;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.hellofresh.driver.Driver;

/**
 * ReportNGReport class with reporting and screenshot functionality
 **/
public class RNGReport extends TestListenerAdapter {
	private static String dirPath = null;
	private static Date date = new Date();
	private static String strStartDate = date.toString().replace(":", "_");
	private static String strDateStamp = strStartDate.replace(" ", "_");

	/**
	 * This method creates the execution report
	 **/
	public static String makDir() {
		String s = Driver.getRelativePath() + "/Resources/ReportNGReports/" + strDateStamp;
		File srcDir = new File(s);
		srcDir.mkdirs();
		return dirPath = srcDir.getAbsolutePath();
	}

	/**
	 * This method captures a screenshot
	 **/
	public static void takeScreenshot(WebDriver ldriver, String screenshotName){

		try {
			TakesScreenshot tss = (TakesScreenshot)ldriver;
		 	File scrnshot = tss.getScreenshotAs(OutputType.FILE);
		 	String filePlace = dirPath + "/ " + screenshotName + "_" + strDateStamp + ".png";
	 		FileUtils.copyFile(scrnshot, new File(filePlace));
	 	
			String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
			System.setProperty(ESCAPE_PROPERTY, "false");
			URL path = new File(filePlace).toURI().toURL();
			String test = "<a href=" + path + "> click to open screenshot of " + screenshotName + "</a>";
			Reporter.log(screenshotName + test + "<br>");
			Reporter.log("<br>");
		}

		catch (Exception e) {
			System.out.println("There was an exception while taking screenshot " + e.getMessage());
		}
	}
}
