package com.hellofresh.challenge;

import org.testng.annotations.Test;

import com.hellofresh.utils.HelperManager;


public class WebTest extends BaseTest{

    @Test
    public void signInTest() {
    	
    	String createdUserName = AccountPO.createUser();
    	String expectedUserName = AccountPO.getSignUpData1("firstname") + " " + AccountPO.getSignUpData1("lastname");
		String testName = HelperManager.readDataFromXML(0, "testName", "signUp");
    	System.out.println("This is " + testName + " running...................");
    	
    	//Perform Validations
		AccountPO.assertForEquals(AccountPO.getHeadingText(), AccountPO.getAccountData1("headingText"), testName);
		AccountPO.assertForEquals(createdUserName, expectedUserName, testName);
		AccountPO.assertForTrue(AccountPO.getAccInfoText().contains(AccountPO.getAccountData1("infoText")), testName);
		AccountPO.assertForTrue(AccountPO.getPageUrl().contains(AccountPO.getAccountData1("pageUrl")), testName);
		AccountPO.assertForTrue(DashboardPO.getSignOutTab().isDisplayed(), testName);
		
		DashboardPO.logout();
    }
    
   @Test
    public void logInTest() {
    	
    	String loginUserName = AccountPO.login();
		String testName = HelperManager.readDataFromXML(0, "testName", "login");
    	System.out.println("This is " + testName + " running...................");
	
		//Perform Validations
		AccountPO.assertForEquals(AccountPO.getHeadingText(), AccountPO.getAccountData1("headingText"), testName);
		AccountPO.assertForEquals(loginUserName, AccountPO.getLoginData1("username"), testName);
		AccountPO.assertForTrue(AccountPO.getAccInfoText().contains(AccountPO.getAccountData1("infoText")), testName);
		AccountPO.assertForTrue(AccountPO.getPageUrl().contains(AccountPO.getAccountData1("pageUrl")), testName);
		AccountPO.assertForTrue(DashboardPO.getSignOutTab().isDisplayed(), testName);
		
		DashboardPO.logout();
    }

    @Test
    public void checkoutTest() {
    	
        AccountPO.login();
        String checkoutPageTitle = CheckoutPO.checkout();
        String testName = HelperManager.readDataFromXML(0, "testName", "checkout");
    	System.out.println("This is " + testName + " running...................");
        
        //Perform Validations
		AccountPO.assertForEquals(CheckoutPO.getHeadingText(), CheckoutPO.getCheckoutData1("headingText"), testName);
		AccountPO.assertForTrue(CheckoutPO.getShippingTab().isDisplayed(), testName);
		AccountPO.assertForTrue(CheckoutPO.getPaymentTab().isDisplayed(), testName);
		AccountPO.assertForEquals(checkoutPageTitle, CheckoutPO.getCheckoutData1("pageTitle"), testName);
		AccountPO.assertForTrue(CheckoutPO.getOrderInfoText().contains(CheckoutPO.getCheckoutData1("infoText")), testName);
		AccountPO.assertForTrue(CheckoutPO.getPageUrl().contains(CheckoutPO.getCheckoutData1("pageUrl")), testName);
		
		DashboardPO.logout();
    }

}