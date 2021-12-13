package guitest;

import static org.junit.Assert.*;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import hooks.TestRunner;

public class GUIStepDefs extends TestRunner{
	
	@Given("the player is on Checkers page")
	public void the_player_is_on_Checkers_page() {
		
		assertEquals(true, driver.findElement(By.xpath("//h1[.='Checkers']")).isDisplayed());
	}

	@When("the player clicks a checker")
	public void the_player_clicks_a_checker() {
		driver.findElement(By.xpath("//*[@src='you1.gif']")).click();
//	    throw new PendingException();
	}

	@Then("the checker is highlighted")
	public void the_checker_is_highlighted() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
