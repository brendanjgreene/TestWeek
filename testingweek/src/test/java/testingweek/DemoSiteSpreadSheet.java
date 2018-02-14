package testingweek;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class DemoSiteSpreadSheet {
	private WebDriver webDriver;
	private static final String BASE_URL ="http://thedemosite.co.uk";
	private static ExtentReports report;
	
	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		
		String fileName = "myReport"+ ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
		
	}
	
	
	
	@Before
	public void before() {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
		
		
	}
	
	@Test
	public void loginTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		refCreatUsr createPage = PageFactory.initElements(webDriver, refCreatUsr.class);
		refHome homePg = PageFactory.initElements(webDriver, refHome.class);
		refernceDemoLogin loginPage = PageFactory.initElements(webDriver, refernceDemoLogin.class);
		//String name = "Brendan";
		//String pass = "passuuuu";
		//String wrongpass = "Wrong";
		
		ReadSpreadSheet testspreadsheet = new ReadSpreadSheet();
		testspreadsheet.spreadSheet();
		
		

		homePg.goToNewUser();
		createPage.enterUserName(testspreadsheet.username);
		createPage.enterUserPass(testspreadsheet.password);
		createPage.clickSave();
		createPage.clickSelectLogin();
		
		try {
			screenShot.take(webDriver, "myScreenShot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.enterUsername(testspreadsheet.username);
		loginPage.enterPassword(testspreadsheet.password);
		loginPage.clickLogin();
		boolean verifyLogin = loginPage.verifyLogin();
		
		Assert.assertTrue("You are not Logged on", verifyLogin);
	}
	
	@Test
	public void loginFailTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		refCreatUsr createPage = PageFactory.initElements(webDriver, refCreatUsr.class);
		refHome homePg = PageFactory.initElements(webDriver, refHome.class);
		refernceDemoLogin loginPage = PageFactory.initElements(webDriver, refernceDemoLogin.class);
		
		ReadSpreadSheet testspreadsheet = new ReadSpreadSheet();
		testspreadsheet.spreadSheet();
		
		

		homePg.goToNewUser();
		createPage.enterUserName(testspreadsheet.username);
		createPage.enterUserPass(testspreadsheet.password);
		createPage.clickSave();
		createPage.clickSelectLogin();
		
		try {
			screenShot.take(webDriver, "myScreenShot2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String wrongPassword = (testspreadsheet.password)+"1";
		loginPage.enterUsername(testspreadsheet.username);
		loginPage.enterPassword(wrongPassword);
		loginPage.clickLogin();
		boolean verifyLogin = loginPage.verifyLogin();
		
		Assert.assertFalse("You are logged in despite wrong password", verifyLogin);
	}
	
	@Test
	public void myFirstTestReport() {
		ExtentTest  test = report.createTest("My First Test");
		test.log(Status.INFO, "My test is started");
		for (int i=0; i<100; i++) {
			test.log(Status.DEBUG, "On Iteration"+i);
		}
		
	}
	
	@After
	public void after() {
		webDriver.quit();
	}
	
	@AfterClass
	public static void tearDown() {
		report.flush();
	}

}
