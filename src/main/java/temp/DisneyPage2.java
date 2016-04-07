

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.webdriver.core.Driver;
import com.epam.webdriver.pageObjects.DisneyResults;

public class DisneyPage2 {

	@FindBy(xpath = "//div[@id='goc-bar']/div/form/input[2]")
	WebElement searchInput;

	// @FindBy(id = "search-e")
	// WebElement searchField;
	//
	// @FindBy(id = "searchField")
	// WebElement searchClose;

	public DisneyPage2() {
		PageFactory.initElements(Driver.get(), this);
	}

	public static DisneyPage2 open() {
		Driver.get().get(System.getProperty("test.disney"));
		return new DisneyPage2();
	}

	public DisneyResults confirmSearch(String input) {
		this.searchInput.sendKeys(input);
		this.searchInput.sendKeys(Keys.ENTER);

		// WebElement button =
		// driver.findElement(By.xpath("//div[@id='goc-bar']/div/form/input[2]"));
		// Click on invisible button via js script
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// button);

		return new DisneyResults();
	}
}
