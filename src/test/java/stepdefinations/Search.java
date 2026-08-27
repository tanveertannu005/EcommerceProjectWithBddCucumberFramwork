package stepdefinations;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.commonUtils;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Search {
	
	WebDriver driver;
	Properties prop;

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	    driver=DriverFactory.getDriver();
	   prop= commonUtils.loadPropertiesFile();
	}

	@When("User Enters existing Product into the search box field")
	public void user_enters_existing_product_into_the_search_box_field() {
		driver.findElement(By.name("search")).sendKeys(prop.getProperty("existingProduct"));
	    
	}

	@And("User clicks on search Button")
	public void user_clicks_on_search_button() {
	    driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	@Then("Product shoud be displayed in search results")
	public void product_shoud_be_displayed_in_search_results() {
	    Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	@When("User Enters non existing Product into the search box field")
	public void user_enters_non_existing_product_into_the_search_box_field() {
		driver.findElement(By.name("search")).sendKeys(prop.getProperty("NonexistingProduct"));
	}

	@Then("Proper message shoud be displayed in search results")
	public void proper_message_shoud_be_displayed_in_search_results() {
	   String expectedMessage="There is no product that matches the search criteria.";
	   Assert.assertEquals(expectedMessage, driver.findElement(By.xpath("//div[@id='content']//p[2]")).getText());
	}


	
}
