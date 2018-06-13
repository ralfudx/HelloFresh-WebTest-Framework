package com.hellofresh.challenge;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hellofresh.driver.DriverFactory;
import com.hellofresh.web_pages.Account;
import com.hellofresh.web_pages.Checkout;
import com.hellofresh.web_pages.Dashboard;

public class BaseTest extends DriverFactory{

    /* Before Class */
	@Parameters({ "browser" })
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) throws Exception {
		driver = invokeBrowser(browser);
		DashboardPO = PageFactory.initElements(driver, Dashboard.class);
		AccountPO = PageFactory.initElements(driver, Account.class);
		CheckoutPO = PageFactory.initElements(driver, Checkout.class);
    }
    
    
    @AfterClass
    public void TearDown() throws IOException, InterruptedException  {
		closeBrowser();
    }

}
