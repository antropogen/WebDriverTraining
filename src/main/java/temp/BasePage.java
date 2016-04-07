

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.webdriver.core.Driver;

public abstract class BasePage {
	WebDriver driver = Driver.get();
	protected BasePage() {
		PageFactory.initElements(driver, this);
	}
}
