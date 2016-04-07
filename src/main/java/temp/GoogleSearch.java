import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA. User: ANTROPOGEN Date: 14.07.13 Time: 17:57 To
 * change this template use File | Settings | File Templates.
 */
public class GoogleSearch {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// --- Type searching query
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("Казаки пишут письмо турецкому султану");
		driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();
		// --- Add delay timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// --- Find amount of the search results and get the text
		String resultsCount = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
		// --- Print amount of the search results
		System.out.print("\n\n" + resultsCount + "\n");
		// --- Find particular result by criterion
		driver.findElement(By.partialLinkText("Запорожцы (карти")).click();
		// --- Find particular result by criterion on Wikipedia site
		driver.findElement(By.xpath("//div[@id='mw-content-text']/ul[2]/li/a")).click();
		
		// --- Print table on screen
//		String table = driver.findElement(By.className("wikitable")).getText();
//		System.out.print("\n" + table);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement resultsTable = driver.findElement(By.className("wikitable"));
		List<WebElement> rows = resultsTable.findElements(By.tagName("tr"));
		for (WebElement megaRow : rows) {
			List<WebElement> nodes = megaRow.findElements(By.tagName("td"));
			for (WebElement node : nodes) {
				System.out.println(node.getText());
			}
		}

		driver.quit();
	}
}
