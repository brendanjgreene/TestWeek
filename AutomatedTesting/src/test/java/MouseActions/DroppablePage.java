package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {
	
	Actions builder = new Actions(webDriver);
	
	@FindBy(css="#draggableview > p")
	protected WebElement dragme;
	
	@FindBy(css="#droppableview")
	protected WebElement dropHere;
	
	public void dropToHere() {
		builder.moveByOffset(dragme.getLocation().getX()+1, dragme.getLocation().getY()+1).click();
	}

}
