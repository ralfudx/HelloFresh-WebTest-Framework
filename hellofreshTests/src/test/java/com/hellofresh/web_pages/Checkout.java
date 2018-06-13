package com.hellofresh.web_pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hellofresh.pages.BasePage;
import com.hellofresh.utils.HelperManager;

/**
 * Hellofresh Checkout Page Object
 **/
public class Checkout extends BasePage {
	@FindBy(linkText = "Women")
	private WebElement womenTab;

	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	private WebElement shoppingItem;
	
	@FindBy(name = "Submit")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	private WebElement proceedToChkoutBtn1;
	
	@FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	private WebElement proceedToChkoutBtn2;
	
	@FindBy(name = "processAddress")
	private WebElement proceedToChkoutBtn3;
	
	@FindBy(id = "uniform-cgv")
	private WebElement termsOfServChkbox;
	
	@FindBy(name = "processCarrier")
	private WebElement proceedToChkoutBtn4;
	
	@FindBy(className = "bankwire")
	private WebElement payByBankwire;
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	private WebElement orderConfirmBtn;
	
	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	private WebElement orderInfo;
	
	@FindBy(css = "h1")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	private WebElement shippingStepTab;
	
	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	private WebElement paymentStepTab;
	
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getHeadingText() {
		return pageHeader.getText();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getOrderInfoText() {
		return orderInfo.getText();
	}
	
	public WebElement getShippingTab() {
		return shippingStepTab;
	}
	
	public WebElement getPaymentTab() {
		return paymentStepTab;
	}
	
	public WebElement getShoppingItem(String itemName) {
		String builtXpath = ("//a[@title='" + itemName + "']/ancestor::li");
		return driver.findElement(By.xpath(builtXpath));
	}

	/**
	 * This method is used to login to ActiTime Application
	 * 
	 * @throws IOException
	 **/
	public String checkout() {
		try {
			HelperManager.expWaitAndClick(womenTab, driver);
			//HelperManager.expWaitAndClick(shoppingItem, driver);
			//shoppingItem.click();
			HelperManager.expWaitAndClick(getShoppingItem(getCheckoutData1("itemName")), driver);
			getShoppingItem(getCheckoutData1("itemName")).click();
			HelperManager.expWaitAndClick(addToCartBtn, driver);
			
			HelperManager.expWaitAndClick(proceedToChkoutBtn1, driver);
			HelperManager.expWaitAndClick(proceedToChkoutBtn2, driver);
			HelperManager.expWaitAndClick(proceedToChkoutBtn3, driver);
			HelperManager.expWaitAndClick(termsOfServChkbox, driver);
			
			proceedToChkoutBtn4.click();
			HelperManager.expWaitAndClick(payByBankwire, driver);
			HelperManager.expWaitAndClick(orderConfirmBtn, driver);
			
			HelperManager.explicitWait(pageHeader, driver);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return driver.getTitle();
	}
	
	/**
	 * This method retrieves a text value from first matching checkoutPage node of an xml document
	 **/
	
	public String getCheckoutData1(String child) {
		return HelperManager.readDataFromXML(0, "checkoutPage", child);
	}

}
