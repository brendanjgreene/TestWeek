package testingweek;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class refCreatUsr {
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	protected WebElement username;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	protected WebElement password;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	protected WebElement saveuserbutton;
	
	@FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	protected WebElement selectLoginbutton;
	
	public boolean checkUsername() {
		return username.isDisplayed();
	}
	public void enterUserName(String username) {
		this.username.sendKeys(username);
	}
	public void enterUserPass(String username) {
		this.password.sendKeys(username);
	}
	public void clickSave() {
		saveuserbutton.click();
	}
	public void clickSelectLogin() {
		selectLoginbutton.click();
	}
} 
