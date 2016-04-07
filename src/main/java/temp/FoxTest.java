//
//
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//
//import com.epam.webdriver.core.BaseTest;
//import com.epam.webdriver.core.Driver;
//
//public class FoxTest extends BaseTest {
//
//	@Test
//	public void foxTest() {
//
//		FoxPage searchPage = FoxPage.open();
//		FoxResults resultsPage = searchPage.performSearch("Breaking Bad");
//        Assert.assertEquals(Driver.get().getCurrentUrl(), "http://10.244.129.93/search", "1Title is not as expected");
//
//		Reporter.log("===============================================\nDone", 2, true);
//
//	}
//
//}
