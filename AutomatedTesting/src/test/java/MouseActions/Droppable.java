package MouseActions;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Droppable {
	
	private WebDriver webDriver;
	private static final String BASE_URL ="http://demoqa.com/droppable/";
	
	
	@Before
	public void setUP() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		

	}
	@Test
	public void dragAndDrop() {
		DroppablePage dropPg = PageFactory.initElements(webDriver, DroppablePage.class);
		//dropPg.
		
		
	}

}
