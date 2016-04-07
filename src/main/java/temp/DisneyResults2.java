//
//
//import java.util.List;
//
//import org.openqa.selenium.support.FindBy;
//
//import com.epam.webdriver.core.Driver;
//import com.epam.webdriver.pageObjects.blocks.SearchResult;
//
//import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
//
//public class DisneyResults2 {
//
//	public DisneyResults2() {
//		HtmlElementLoader.populatePageObject(this, Driver.get());
//	}
//
//	public boolean isLinkInResults(String link) {
//		for (SearchResult result : searchResults) {
//			if (result.getURL().equals(link)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@FindBy(xpath = "//div[@id='main']/div/div[2]/section/ul/li/div[1]/a")
//
//	private List<SearchResult> searchResults;
//
//}
