package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtilities {
	WebDriver driver;
	
	public ElementUtilities(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void clickOnElement(WebElement element) {
		if(element.isDisplayed()&&element.isEnabled()) {
			element.click();
		}
		
			
	}
	public void enterTextIntoElement(WebElement element,String text) {
		if(element.isDisplayed()&&element.isEnabled()&&element.getDomAttribute("readOnly")==null) {
			element.click();
			element.sendKeys(text);
			
		}
	}
	
}
