package com.hellofresh.web_pages;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hellofresh.driver.Driver;
import com.hellofresh.pages.BasePage;
import com.hellofresh.report.RNGReport;
import com.hellofresh.utils.HelperManager;

/**
 * Hellofresh Account Page Object
 **/
public class Account extends BasePage {
	@FindBy(id = "email")
	private WebElement emailField_Login;

	@FindBy(id = "passwd")
	private WebElement passwordField_Login;

	@FindBy(id = "SubmitLogin")
	private WebElement submitButton_Login;
	
	@FindBy(className = "account")
	private WebElement accountNameTab;

	@FindBy(className = "login")
	private WebElement signInTab;
	
	@FindBy(id = "email_create")
	private WebElement emailField_Create;
	
	@FindBy(id = "SubmitCreate")
	private WebElement submitButton_Create;
	
	@FindBy(id = "id_gender2")
	private WebElement genderbox;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "customer_lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "passwd")
	private WebElement passwordField_Create;
	
	@FindBy(id = "company")
	private WebElement companyField;
	
	@FindBy(id = "address1")
	private WebElement address1Field;
	
	@FindBy(id = "address2")
	private WebElement address2Field;
	
	@FindBy(id = "city")
	private WebElement cityField;
	
	@FindBy(id = "postcode")
	private WebElement postCodeField;
	
	@FindBy(id = "other")
	private WebElement otherField;
	
	@FindBy(id = "phone")
	private WebElement phoneField;
	
	@FindBy(id = "phone_mobile")
	private WebElement phoneMobileField;
	
	@FindBy(id = "alias")
	private WebElement aliasField;
	
	@FindBy(id = "submitAccount")
	private WebElement submitAccButton;
	
	@FindBy(id = "days")
	private WebElement daysDropdownTab;
	
	@FindBy(id = "months")
	private WebElement monthsDropdownTab;
	
	@FindBy(id = "years")
	private WebElement yearsDropdownTab;
	
	@FindBy(id = "id_state")
	private WebElement stateDropdownTab;
	
	@FindBy(css = "h1")
	private WebElement pageHeader;
	
	@FindBy(className = "info-account")
	private WebElement accountInfo;
	
	public Account(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getHeadingText() {
		return pageHeader.getText();
	}
	
	public String getAccInfoText() {
		return accountInfo.getText();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * This method is used to login to the Application
	 * 
	 * @throws IOException
	 **/
	public String login() {
		try {
			driver.get(Driver.getDesktopUrl());
			HelperManager.expWaitAndClick(signInTab, driver);
			
			HelperManager.explicitWait(emailField_Login, driver);
			emailField_Login.sendKeys(getLoginData1("email"));
	        passwordField_Login.sendKeys(getLoginData1("password"));
	        submitButton_Login.click();
	        
	        HelperManager.explicitWait(pageHeader, driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
        return accountNameTab.getText();
	}
	

	/**
	 * This method is used to create a user
	 **/
	public String createUser() {
		try {
			HelperManager.expWaitAndClick(signInTab, driver);
	        String timestamp = String.valueOf(new Date().getTime());
	        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
	        
	        emailField_Create.sendKeys(email);
	        submitButton_Create.click();
	        
	        HelperManager.explicitWait(genderbox, driver);
	        genderbox.click();
	        
	        firstNameField.sendKeys(getSignUpData1("firstname"));
	        lastNameField.sendKeys(getSignUpData1("lastname"));
	        passwordField_Create.sendKeys(getSignUpData1("password"));
	        
	        Select select = new Select(daysDropdownTab);
	        select.selectByValue("1");
	        select = new Select(monthsDropdownTab);
	        select.selectByValue("1");
	        select = new Select(yearsDropdownTab);
	        select.selectByValue("2000");
	        
	        companyField.sendKeys(getSignUpData1("company"));
	        address1Field.sendKeys(getSignUpData1("address1"));
	        address2Field.sendKeys(getSignUpData1("address2"));
	        cityField.sendKeys(getSignUpData1("city"));
	        
	        select = new Select(stateDropdownTab);
	        select.selectByVisibleText(getSignUpData1("state"));
	        
	        postCodeField.sendKeys(getSignUpData1("postCode"));
	        otherField.sendKeys(getSignUpData1("other"));
	        phoneField.sendKeys(getSignUpData1("phone"));
	        phoneMobileField.sendKeys(getSignUpData1("phoneMobile"));
	        aliasField.sendKeys(getSignUpData1("alias"));
	        submitAccButton.click();
	        
			HelperManager.explicitWait(pageHeader, driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	        
        return accountNameTab.getText();
	}
	
	/**
	 * This method asserts a true condition and captures a screenshot for failed cases
	 **/
	public void assertForTrue(boolean condition, String testName) {
		if(!condition) {
			System.out.println("Condition is: " + condition);
			RNGReport.takeScreenshot(driver, testName);
		}
		Assert.assertTrue(condition);
	}
	
	/**
	 * This method asserts an equal condition and captures a screenshot for failed cases
	 **/
	public void assertForEquals(String actual, String expected, String testName) {
		if(expected.equals(actual) == false) {
			System.out.println("Actual: " + actual + " is equal to Expected: " + expected);
			RNGReport.takeScreenshot(driver, testName);
		}
		Assert.assertEquals(actual, expected);
	}
	
	/**
	 * This method retrieves a text value from first matching login node of an xml document
	 **/
	
	public String getLoginData1(String child) {
		return HelperManager.readDataFromXML(0, "login", child);
	}


	/**
	 * This method retrieves a text value from first matching newUser node of an xml document
	 **/
	
	public String getSignUpData1(String child) {
		return HelperManager.readDataFromXML(0, "newUser", child);
	}
	
	/**
	 * This method retrieves a text value from first matching accountPage node of an xml document
	 **/
	
	public String getAccountData1(String child) {
		return HelperManager.readDataFromXML(0, "accountPage", child);
	}

}
