package hooks;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.Feature;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {
//				"features/apiDemo.feature",
				"features/guiDemo.feature"
				},
		glue = {"apitest", "guitest"},
		tags = {},
		plugin = "pretty",
		strict = true,
		monochrome = true,
		dryRun = false	
		
		)
//@Feature(value = "TestRunner")
public class TestRunner {
	
	public static WebDriver driver;
	public static String url = "https://www.gamesforthebrain.com/game/checkers/";
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
