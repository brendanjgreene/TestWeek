package testingweek;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

public class JunitExample {
	
	private WebDriver webDriver;
	private static final String BASE_URL ="https://www.qa.com";
	
	@BeforeClass
	public static void init() {
		System.out.println("Before Class");
		//Initialise a test report
	}
	@Before
	public void setUP() {
		System.out.println("Before");
		// set up variables needed for all tests base url for example
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
	}
	@Test
	public void printTest() {
		System.out.println("Test");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
			String URL = webDriver.getCurrentUrl();
		Assert.assertEquals("True", URL, BASE_URL);
		WebElement searchBar = webDriver.findElement(By.cssSelector("#select2-chosen-2"));
		searchBar.sendKeys("THE SHAFEEQ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@After
	public void cleanUp() {
		System.out.println("After");
		// clean up variables needed for all tests base url for example
		webDriver.quit();
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("After Class");
		//Finalise test report
	}
	
	
	

}
