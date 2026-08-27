package stepdefinations;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.commonUtils;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Login {

	WebDriver driver;
	Properties prop;

	@Given("User Navigates to Login Page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		prop = commonUtils.loadPropertiesFile();

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();

	}

	@When("User enters Valid Email and valid password into the fields")
	public void user_enters_valid_email_and_valid_password_into_the_fields() {
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));

	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User shoud Get logged in Succesfully")
	public void user_shoud_get_logged_in_succesfully() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
	}

	@And("User Shoud be taken to My Account page")
	public void And_User_Shoud_be_taken_to_My_Account_page() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
	}

	@When("User enters inValid Email and invalid password into the fields")
	public void user_enters_in_valid_email_and_invalid_password_into_the_fields() {
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmailwithNanoTime());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("InvalidPassword"));
	}

	@Then("User shoud not Get loggedin")
	public void user_shoud_not_get_loggedin() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());
	}

	@Then("User Shoud get a proper warning message")
	public void user_shoud_get_a_proper_warning_message() {
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedWarning,
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
	}

}
