import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AutomatedTest2 {
	
	private WebDriver webDriver;
	private static final String BASE_URL ="http://automationpractice.com";
	private static ExtentReports report;
	
	public static String take(WebDriver webDriver, String fileName) throws IOException{
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		String pathname = System.getProperty("user.dir") + File.separatorChar + fileName + ".jpg";
		FileUtils.copyFile(scrFile, new File(pathname));
		System.out.println("File Saved at: " + pathname);
		return pathname;
	}
	
	@BeforeClass
	public static void init() {
		System.out.println("BeforeClass");
		report = new ExtentReports();
		
		String fileName = "automated"+ ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
		
	}
	@Before
	public void setUP() {
		System.out.println("Before");
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
		
		
	}
	@Test
	public void runTest2() {
		ExtentTest  Test2 = report.createTest("My First Test");
		Test2.log(Status.DEBUG, "Test has Started");
		System.out.println("Test");
		HomePage homepg = PageFactory.initElements(webDriver, HomePage.class);
		homepg.goToContact();
		Test2.log(Status.DEBUG, "On contact page");
		ContactPage contactpg = PageFactory.initElements(webDriver, ContactPage.class);
		contactpg.selectContactType();
		Test2.log(Status.DEBUG, "ContactType has been selected");
		contactpg.selectCustomerService();
		Test2.log(Status.DEBUG, "Customer Service has been selected");
		contactpg.enterEmail();
		Test2.log(Status.DEBUG, "email has been entered");
		contactpg.enterOrderId();
		Test2.log(Status.DEBUG, "oder id entered" );
		contactpg.enterMessage();
		Test2.log(Status.DEBUG, "message enterd");
		try {
			take(webDriver, "message before it is sent");
		}catch(IOException e) {
			e.printStackTrace();
		}
		contactpg.sendMessage();
		Test2.log(Status.DEBUG, "Send Button has been clicke");
		try {
			take(webDriver, "alertMessage success");
		}catch(IOException e) {
			e.printStackTrace();
		}
		boolean verifySend = contactpg.verifyMessage();
		Assert.assertTrue("message send success", verifySend);
		Test2.pass("Your test has ran successfully");
		
		
		
		
	}
	@After
	public void tearDown() {
		System.out.println("After");
		webDriver.quit();
	}
	@AfterClass
	public static void cleanUp() {
		System.out.println("AfterClass");
		report.flush();
	}

}
