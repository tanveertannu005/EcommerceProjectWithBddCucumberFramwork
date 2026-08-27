package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.commonUtils;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {

	WebDriver driver;

	@Before
	public void setup() {

		driver = DriverFactory.openBrowserAndApplicationURL(commonUtils.loadPropertiesFile());

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
