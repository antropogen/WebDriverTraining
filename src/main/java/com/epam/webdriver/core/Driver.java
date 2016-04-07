package com.epam.webdriver.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Driver {

	// --- hide the method of this class
	private static WebDriver driver;

	// --- create method to set parameters of driver
	private static void set(WebDriver driverInput) {
		driver = driverInput;
	}

	// --- create method to get a driver
	public static WebDriver get() {
		return driver;
	}

	// --- create method for assertion of element presence
	public boolean isElementPresent(By locator) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// --- array of elements that has to be found
		List<WebElement> elements = driver.findElements(locator);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// --- condition to check presence of the first element in array that
		// had been found
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}

	public static void init() {
		Properties properties = new Properties();
		FileInputStream propFile;
		try {
			propFile = new FileInputStream("test.properties");
			properties.load(propFile);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		@SuppressWarnings("unchecked")
		Enumeration<String> e = (Enumeration<String>) properties.propertyNames();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			System.setProperty(key, properties.getProperty(key));
			Reporter.log(key + " - " + properties.getProperty(key), 2, true);
		}
		WebDriver driverInput = new FirefoxDriver();
		driverInput.manage().window().maximize();
		driverInput.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("test.timeout")),
				TimeUnit.SECONDS);
		Driver.set(driverInput);
	}

	public static void tearDown() {
		Driver.get().quit();

	}

}
