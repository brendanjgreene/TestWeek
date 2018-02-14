package testingweek;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

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
	/*@Test
	public void rightSite() {
		System.out.println("Test");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	public void loginTest() {
		System.out.println("login Test");
		WebElement selectAddUser = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
		selectAddUser.click();
		WebElement enterUsrName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		enterUsrName.sendKeys("Brendan");
		WebElement enterUsrPass = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		enterUsrPass.sendKeys("password");
		WebElement saveUsr = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		saveUsr.click();
		WebElement selectLogin = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
		selectLogin.click();
		WebElement userName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		userName.sendKeys("Brendan");
		WebElement userPass = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		userPass.sendKeys("password");
		WebElement testLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		testLogin.click();
		//String successMessage = "**Successful Login**";
		WebElement message = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		//String resultMessage = message.getText();
		assertEquals("Passed", message.getText(), "**Successful Login**");
	}
	
	@After
	public void cleanUp() {
		webDriver.quit();
	}
	@AfterClass
	public static void tearDown() {
		
	}

}
