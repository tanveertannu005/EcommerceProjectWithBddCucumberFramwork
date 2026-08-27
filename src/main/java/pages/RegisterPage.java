package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;

public class RegisterPage {
	WebDriver driver;
	ElementUtilities elementUtilities;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilities = new ElementUtilities(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameField;

	@FindBy(id = "input-lastname")
	WebElement lastNamefield;

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-telephone")
	WebElement telephoneField;

	@FindBy(id = "input-password")
	WebElement passwordField;

	@FindBy(id = "input-confirm")
	WebElement confirmPasswordField;

	@FindBy(css = "input[name='newsletter'][value='1']")
	WebElement yesNewsletterOption;

	@FindBy(name = "agree")
	WebElement privacypolicyOption;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	public void enterFirstName(String firsNameText) {
		firstNameField.sendKeys(firsNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNamefield.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String passwordText) {
		confirmPasswordField.sendKeys(passwordText);
	}

	public void selectYesNewsletterOption() {
		elementUtilities.clickOnElement(yesNewsletterOption);

	}

	public void selectprivacyPolicyOption() {
		elementUtilities.clickOnElement(privacypolicyOption);

	}

	public AccountSuccessPage clickOnContinueButton() {
		elementUtilities.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
	}
}
