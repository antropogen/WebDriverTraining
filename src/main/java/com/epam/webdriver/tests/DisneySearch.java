package com.epam.webdriver.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.epam.webdriver.core.BaseTest;
import com.epam.webdriver.pageObjects.DisneyPage;
import com.epam.webdriver.pageObjects.DisneyResults;

public class DisneySearch extends BaseTest {

	@Test

	public void disneySearch() {

		DisneyPage.open().confirmSearch("Gravity");
		DisneyResults results = new DisneyResults();
		results.getURL();

		Reporter.log("===============================================\nSearching in results is Done"
				+ "\n===============================================", 2, true);

	}
}
