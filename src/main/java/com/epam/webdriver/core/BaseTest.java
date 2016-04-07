package com.epam.webdriver.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
	// --- create method to initialize browser
	public void init() {
		Driver.init();
	}

	@AfterMethod
	// --- create method to close browser
	public void cleanup() {
		Driver.tearDown();
	}

}
