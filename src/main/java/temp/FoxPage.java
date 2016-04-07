

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.webdriver.core.Driver;

public class FoxPage {

	@FindBy(xpath = "//form/div/input")
	WebElement searchInput;

	@FindBy(xpath = "//div/form/button")
	WebElement confirmButton;

	public FoxPage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public static FoxPage open() {
		Driver.get().get(System.getProperty("test.searchURL"));
		return new FoxPage();
	}

	public FoxResults performSearch(String input) {
		this.searchInput.sendKeys(input);
		
		this.confirmButton.click();
		return new FoxResults();

	}

}
