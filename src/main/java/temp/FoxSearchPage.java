

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.webdriver.core.Driver;

public class FoxSearchPage extends BasePage {
	private static FoxSearchPage page;

	@FindBy(xpath = "//form/div/input")
	WebElement searchInput;

	@FindBy(className = "btn btn-default")
	WebElement confirmButton;

	 public FoxSearchResult performSearch(String input) {
	 this.searchInput.sendKeys(input);
	 this.confirmButton.click();
	 return new FoxSearchResult();
	 }

	public static FoxSearchPage open() {
		Driver.get().get(System.getProperty("test.baseURL"));
		return new FoxSearchPage();
	}

	public static FoxSearchPage getPage() {
		if (page == null) {
			page = new FoxSearchPage();
		}
		return page;
	}
}
