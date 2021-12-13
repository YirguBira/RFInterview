package guitest;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WDriver {
	
	static WebDriver driver;
	static String url = "https://www.gamesforthebrain.com/game/checkers/";
	
	@BeforeClass
	public static void setUp(){
		System.getProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
