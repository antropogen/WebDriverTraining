package com.epam.webdriver.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleResultsArray {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.ua");		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Try to handle hidden element
		WebElement focus = driver.findElement(By.className("gb_ga")); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", focus);

		WebElement element = driver.findElement(By.className("gsfi"));
		element.sendKeys("selenium webdriver");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Get the search results panel that contains the link for each result.
		WebElement resultsPanel = driver.findElement(By.id("sblsbb"));
		resultsPanel.click();

		// Get all the links only contained within the search result panel.
		List<WebElement> searchResults = driver.findElements(By.xpath(".//a"));

		// Print the text for every link in the search results.
		for (WebElement webElement : searchResults) {
			System.out.println(webElement.getText());
		}
		driver.close();

	}

}
