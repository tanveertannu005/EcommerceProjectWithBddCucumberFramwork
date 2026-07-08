package stepdefinations;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Register {
	
	WebDriver driver;
	
	
	@Before
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap();
		driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(generateEmailwithNanoTime());
		driver.findElement(By.id("input-telephone")).sendKeys(map.get("TelephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(map.get("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(map.get("Password"));
	}

	@And("User Select Privacy Policy field")
	public void user_select_privacy_policy_field() {
	    driver.findElement(By.name("agree")).click();
	}

	@And("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User shoud get logged in")
	public void user_shoud_get_logged_in() {
	    Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
	}

	@Then("User Shoud be naviagated to Account Success page")
	public void user_shoud_be_naviagated_to_account_success_page() {
	    Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	}

	@And("Proper Details Shoud be displayed Account Success page")
	public void proper_details_shoud_be_displayed_account_success_page() {
		//next session
	}

	@When("User Clicks on continue on Account Success page")
	public void user_clicks_on_continue_on_account_success_page() {
	    driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}

	@Then("User Shoud be navigated to MyAccountpage")
	public void user_shoud_be_navigated_to_my_accountpage() {
		Assert.assertEquals("My Account", driver.getTitle());
	    
	}
	
	public static String generateEmailwithNanoTime() {
	    return "user" + System.currentTimeMillis()
	            + System.nanoTime()
	            + "@gmail.com";
	}
}
