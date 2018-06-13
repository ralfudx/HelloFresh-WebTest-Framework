package com.hellofresh.driver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hellofresh.web_pages.Account;
import com.hellofresh.web_pages.Checkout;
import com.hellofresh.web_pages.Dashboard;

/**
 * DriverFactory class to create WebDriver instance to run automated tests against desktop browsers.
 **/
public class DriverFactory {
	protected WebDriver driver;
	protected Account AccountPO;
	protected Checkout CheckoutPO;
	protected Dashboard DashboardPO;

	/* Properties to trigger Chrome browser*/
	protected void chromeDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	}

	/* Properties to trigger Firefox browser*/
	protected void firefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	/* Properties to trigger IE browser*/
	@SuppressWarnings("deprecation")
	protected void ieDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver","./src/main/resources/iedriver/IEDriverServer.exe");
		driver = new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
	}

	/**
	 * This method invokes a standalone browser
	 * 
	 **/
	protected WebDriver invokeBrowser(String browser) throws MalformedURLException {
		if (browser.equalsIgnoreCase("firefox")) {
			firefoxDriver();
			return driver;
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			chromeDriver();
			return driver;
		}

		else if (browser.equalsIgnoreCase("internetexplorer")) {
			ieDriver();
			return driver;
		}
		return driver;
	}
	/**
	 * This method closes the browser
	 **/
	protected void closeBrowser() throws IOException {
		driver.quit();
	}
}
