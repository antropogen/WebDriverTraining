package com.epam.webdriver.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.epam.webdriver.core.Driver;

public class DisneyResults {

	// @FindBy(xpath = "//div[@id='main']/div/div[2]/section/ul/li/div[1]/a")
	// WebElement searchResults;

	WebElement webElement;

	public DisneyResults() {
		PageFactory.initElements(Driver.get(), this);

	}

	public DisneyResults getURL() {

		// Get all the links only contained within the search result panel.
		List<WebElement> searchResults = Driver.get()
				.findElements(By.xpath("//div[@id='main']/div/div[2]/section/ul/li/div[1]/a"));

		// Print every link in the search results.
		boolean linkFound = false;
		String searchLink = "http://disneyxd.disney.co.uk/gravity-falls";

		for (WebElement webElement : searchResults) {
			String link = webElement.getAttribute("href");
			System.out.println(">>> Required link: " + link + "\n   is in the results");
			if (link.contains(searchLink)) {
				linkFound = true;
				break;
			}
			Assert.assertTrue(linkFound, "Link is in search results");
		}
		return new DisneyResults();
	}
}
