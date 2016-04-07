package com.epam.webdriver.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ReturnAllResultLinks {

	WebDriver driver;

	@Test
	public void getURL() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://disney.co.uk/");

		WebElement element = driver.findElement(By.xpath("//div[@id='goc-bar']/div/form/input[2]"));
		element.sendKeys("Gravity");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		element.sendKeys(Keys.ENTER);

		// Get all the links only contained within the search result panel.
		List<WebElement> searchResults = driver
				.findElements(By.xpath("//div[@id='main']/div/div[2]/section/ul/li/div[1]/a"));

		// Print every link in the search results.
		boolean linkFound = false;
		String searchLink = "http://disneyxd.disney.co.uk/gravity-falls";

		for (WebElement webElement : searchResults) {
			String link = webElement.getAttribute("href");
			System.out.println(">>> Searched link: " + link + "\nis in a search results");
			if (link.contains(searchLink)) {
				linkFound = true;
				break;
			}
			Assert.assertTrue(linkFound, "Link is in search results");
		}
	}

	@AfterClass
	public void cleanup() {
		driver.quit();
	}
}
