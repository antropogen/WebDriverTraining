import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IsElementPresentTest4 {

	WebDriver driver;

	@Test
	public void isElementPresentTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://twitter.com");
		Assert.assertEquals(driver.getTitle(), "Twitter", "Title is not as expected");
		Assert.assertTrue(isElementPresent(By.id("signin-email")), "Element is not shown");
		Assert.assertFalse(isElementPresent(By.id("signin-email42")), "Element is shown");
	}

	private boolean isElementPresent(By locator) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> elements = driver.findElements(locator);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}

	@AfterClass
	public void cleanup() {
		driver.quit();
	}
}
