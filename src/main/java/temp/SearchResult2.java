


import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class SearchResult2 extends HtmlElement {

	@FindBy(className = "result_ul")
	Link mainLink;

	@FindBy(className = "title-wrap")
	Link fulllLink;
	
	@FindBy(className = "route")
	Link fulllLink1;

	// div[@id='main']/div/div[2]/section/ul/li/div[1]/a
	// div[@id='main']/div/div[2]/section/ul

	public String getURL() {
		return fulllLink1.getReference();
	}

//	public String resToString() {
//		return fulllLink.getText();
//	}

}
