package com.hellofresh.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.w3c.dom.*;

import com.hellofresh.report.RNGReport;

/**
 * This is a Helper class with all generic methods
 **/
public class HelperManager {
	private static WebDriverWait wait;
	
	/**
	 * This method makes the driver wait for specified seconds
	 **/
	public static void normalWait(WebDriver driver, long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method makes the driver wait implicitly
	 **/
	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	/**
	 * This method makes the driver wait till the web element is located
	 **/
	public static void explicitWait(WebElement wb, WebDriver driver) {
		try {
			wait = new WebDriverWait(driver, 10, 50);
			wait.until(ExpectedConditions.visibilityOf(wb));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method makes the driver wait till the web element is located then clicks it
	 **/
	public static void expWaitAndClick(WebElement wb, WebDriver driver) {
		try {
			wait = new WebDriverWait(driver, 10, 50);
			wait.until(ExpectedConditions.visibilityOf(wb)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Method to get properties
	 */
	public static Properties getProperties(String propFilePath) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(propFilePath);
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	/**
	 * This method runs the XML suite file dynamically
	 **/

	public static void autoRunXml() {
		List<String> files = new ArrayList<String>();
		files.add("./src/test/resources/suites/desktop.xml");

		TestNG tng = new TestNG();
		tng.setOutputDirectory(RNGReport.makDir());
		tng.setUseDefaultListeners(false);
		tng.setTestSuites(files);
		tng.run();

	}
	
	public static String readDataFromXML(int parentNodeNum, String parent, String child) {
		String XMLFilePath = "./src/test/resources/data/test_data.xml";
		String XMLDataRetrieved = "";
		try {
	
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(XMLFilePath));
	
			// Normalise text representation
			doc.getDocumentElement ().normalize ();
			//System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
	
	
			NodeList ParentTagList= doc.getElementsByTagName(parent);
			int totalNumParent = ParentTagList.getLength();
			//System.out.println("Total no of " + parent + " tag is : " + totalNumParent);
			
			if(parentNodeNum <= totalNumParent) {
				Node selectedParentNode = ParentTagList.item(parentNodeNum);
				if(selectedParentNode.getNodeType() == Node.ELEMENT_NODE){
					Element SelectedParentElement = (Element)selectedParentNode; 
			
					NodeList childTagList = SelectedParentElement.getElementsByTagName(child);
					Element childElement = (Element)childTagList.item(0);
			
					NodeList textFNList = childElement.getChildNodes();
					XMLDataRetrieved = ((Node)textFNList.item(0)).getNodeValue().trim();
					//System.out.println("Text is : " + XMLDataRetrieved);
				}
			}else {
				System.out.println("Parent node number must be equal or less than " + totalNumParent);
			}
		}catch (SAXParseException err) {
			System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
			System.out.println(" " + err.getMessage ());

		}catch (SAXException e) {
			Exception x = e.getException ();
			((x == null) ? e : x).printStackTrace ();

		}catch (Throwable t) {
			t.printStackTrace ();
		}

		return XMLDataRetrieved;
	}

}
