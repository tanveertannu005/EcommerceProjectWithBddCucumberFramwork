package stepdefinations;

import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.commonUtils;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.Homepage;
import pages.RegisterPage;

public class Register {

	WebDriver driver;
	Properties prop;
	Homepage homepage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		prop = commonUtils.loadPropertiesFile();
		homepage = new Homepage(driver);
		homepage.clickOnMyAccountDropMenu();
		registerPage = homepage.SelectregisterOption();
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		registerPage.enterFirstName(map.get("firstName"));
		registerPage.enterLastName(map.get("lastName"));
		registerPage.enterEmail(commonUtils.generateEmailwithNanoTime());
		registerPage.enterTelephoneNumber(map.get("TelephoneNumber"));
		registerPage.enterPassword(map.get("Password"));
		registerPage.enterConfirmPassword(map.get("Password"));

	}

	@And("User selects Yes option for the Newsletter")
	public void User_selects_Yes_option_for_the_Newsletter() {

		registerPage.selectYesNewsletterOption();

	}

	@And("User Select Privacy Policy field")
	public void user_select_privacy_policy_field() {

		registerPage.selectprivacyPolicyOption();

	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage = registerPage.clickOnContinueButton();

	}

	@Then("User shoud get logged in")
	public void user_shoud_get_logged_in() {
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
	}

	@Then("User Shoud be naviagated to Account Success page")
	public void user_shoud_be_naviagated_to_account_success_page() {
		accountSuccessPage.didWeNavigateToAccountSuccessPage();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	}

	@And("Proper Details Shoud be displayed Account Success page")
	public void proper_details_shoud_be_displayed_account_success_page() {
		// next session
	}

	@When("User Clicks on continue on Account Success page")
	public void user_clicks_on_continue_on_account_success_page() {
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}

	@Then("User Shoud be navigated to MyAccountpage")
	public void user_shoud_be_navigated_to_my_accountpage() {
		Assert.assertEquals("My Account", driver.getTitle());

	}

}