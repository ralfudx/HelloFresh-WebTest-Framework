package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hellofresh.driver.DriverFactory;

/* 
 * BasePage with constructor to initialise driver 
 */

public class BasePage extends DriverFactory{
	//protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}