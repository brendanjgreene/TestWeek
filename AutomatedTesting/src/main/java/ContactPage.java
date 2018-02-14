import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {

	@FindBy(css="#id_contact")
	protected WebElement subjectField;
	
	public void selectContactType() {
		subjectField.click();
	}
	
	@FindBy(css="#id_contact > option:nth-child(2)")
	protected WebElement chooseCustomerService;
	
	public void selectCustomerService() {
		chooseCustomerService.click();
	}
	
	@FindBy(css="#email")
	protected WebElement emailField;
	
	public void enterEmail() {
		emailField.sendKeys("email@Example.com");
	}
	
	@FindBy(css="#id_order")
	protected WebElement orderRef;
	
	public void enterOrderId() {
		orderRef.sendKeys("111");
	}
	
	@FindBy(css="#message")
	protected WebElement messageField;
	
	public void enterMessage() {
		messageField.sendKeys("Hello My Friend");
	}
	
	@FindBy(css="#submitMessage")
	protected WebElement sendBTN;
	
	public void sendMessage() {
		sendBTN.click();
	}
	
	@FindBy(css="#center_column > p")
	protected WebElement alertmessage;
	
	public boolean verifyMessage() {
		String text = alertmessage.getText();
		System.out.println(text);
		return alertmessage.isDisplayed()&&"Your message has been successfully sent to our team.".equals(text);
	}
	
	
	
	
}
