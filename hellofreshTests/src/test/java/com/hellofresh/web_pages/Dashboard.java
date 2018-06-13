package com.hellofresh.web_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hellofresh.pages.BasePage;
import com.hellofresh.utils.HelperManager;

/**
 * Hellofresh Dashboard Page Object
 **/

public class Dashboard extends BasePage {

	@FindBy(className = "login")
	private WebElement signInTab;
	
	@FindBy(className = "logout")
	private WebElement signOutTab;
	
	@FindBy(id = "header_logo")
	private WebElement HeaderLogo;

	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * This method gets the text on the sign out tab
	 **/
	public WebElement getSignOutTab() {
		return signOutTab;
	}

	/**
	 * This method checks the dashboard header logo
	 **/
	public String checkPageHeader() {
		HelperManager.explicitWait(HeaderLogo, driver);
		return driver.getTitle();
	}

	/**
	 * This method makes user logout
	 **/
	public String logout() {
		HelperManager.explicitWait(signOutTab, driver);
		signOutTab.click();
		HelperManager.explicitWait(signInTab, driver);
		return driver.getTitle();
	}
}
