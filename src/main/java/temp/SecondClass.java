import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SecondClass {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void openGoogle() {

		driver.get("https://twitter.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/", "Url is not as expected");

	}

	@AfterClass
	public void cleanup() {
		driver.quit();
	}
}
