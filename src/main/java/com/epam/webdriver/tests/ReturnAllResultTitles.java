package com.epam.webdriver.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ReturnAllResultTitles {

	WebDriver driver;

	@Test

	public void getURLTitles() {

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

		// Print the text for every link in the search results.
		for (WebElement webElement : searchResults) {
			System.out.println(webElement.getText());
		}

	}

	@AfterClass
	public void cleanup() {
		driver.quit();
	}
}
