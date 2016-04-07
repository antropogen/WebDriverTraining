package com.epam.webdriver.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.webdriver.core.Driver;

public class DisneyPage {

	@FindBy(xpath = "//div[@id='goc-bar']/div/form/input[2]")
	WebElement searchInput;

	public DisneyPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public static DisneyPage open() {
		Driver.get().get("http://disney.co.uk/");
		return new DisneyPage();

	}

	public DisneyResults confirmSearch(String input) {
		this.searchInput.sendKeys(input);
		this.searchInput.sendKeys(Keys.ENTER);

		return new DisneyResults();
	}

	public DisneyResults findAllLinks () {
		

		return new DisneyResults();
	}
}
