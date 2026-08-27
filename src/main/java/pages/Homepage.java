package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import Utils.elementUtilities;

public class Homepage {

	WebDriver driver;
	ElementUtilities elementUtilities;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtilities=new ElementUtilities(driver);
	}
	
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Register")
	WebElement registerOption;
	
	public void clickOnMyAccountDropMenu() {
		elementUtilities.clickOnElement(myAccountDropMenu);
		
	}
	public RegisterPage  SelectregisterOption() {
		elementUtilities.clickOnElement(registerOption);
		return new RegisterPage(driver);
	}
}


