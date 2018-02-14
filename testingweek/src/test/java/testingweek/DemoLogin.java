package testingweek;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class DemoLogin {
	
	private WebDriver webDriver;
	private static final String BASE_URL ="http://thedemosite.co.uk";
	
	@BeforeClass
	public static void init() {
		
	}
	
	
	
	@Before
	public void before() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
		
		
	}
	
	@Test
	public void loginTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		refCreatUsr createPage = PageFactory.initElements(webDriver, refCreatUsr.class);
		refHome homePg = PageFactory.initElements(webDriver, refHome.class);
		refernceDemoLogin loginPage = PageFactory.initElements(webDriver, refernceDemoLogin.class);
		String name = "Brendan";
		String pass = "passuuuu";
		String wrongpass = "Wrong";

		homePg.goToNewUser();
		//createPage.checkUsername();
		createPage.enterUserName(name);
		createPage.enterUserPass(pass);
		createPage.clickSave();
		createPage.clickSelectLogin();
		//loginPage.checkUsername();
		loginPage.enterUsername(name);
		loginPage.enterPassword(pass);
		loginPage.clickLogin();
		boolean verifyLogin = loginPage.verifyLogin();
		
		Assert.assertTrue("You are not Logged on", verifyLogin);
	}
	
	@After
	public void after() {
		webDriver.quit();
	}
	
	@AfterClass
	public static void tearDown() {
		
	}

}
