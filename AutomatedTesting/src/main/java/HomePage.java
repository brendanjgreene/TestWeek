import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(css="#contact-link > a")
	protected WebElement contactLink;
	
	public void goToContact()
	{
		contactLink.click();
	}

}
