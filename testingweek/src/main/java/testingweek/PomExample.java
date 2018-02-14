package testingweek;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PomExample {
	
	private WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to("https://www.google.com");
	}
	
	@Test
	public void pomEx() {
		
	}
	
	

}
