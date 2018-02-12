package testingweek;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class intermediate {
	
	private WebDriver webDriver;
	private static final String BASE_URL ="http://thedemosite.co.uk";
	
	@BeforeClass
	public static void init() {
		
	}
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
	}
	@Test
	public void rightSite() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After
	public void cleanUp() {
		webDriver.quit();
	}
	@AfterClass
	public static void tearDown() {
		
	}

}
