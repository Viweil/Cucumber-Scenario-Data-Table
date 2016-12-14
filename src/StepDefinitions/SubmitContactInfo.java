package StepDefinitions;

import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubmitContactInfo {

	WebDriver driver = null;
	
	@Given("^I am on the zoo website$")
	public void i_am_on_the_zoo_website() throws Throwable {
			System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("http://thetestroom.com/webapp/");
			Thread.sleep(500);
	}

	@When("^I navigate to contact$")
	public void i_navigate_to_contact() throws Throwable {
		driver.findElement(By.id("contact_link")).click();
		Thread.sleep(500);
	}

	@When("^I submit the form with valid data$")
	public void i_submit_the_form_with_valid_data(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		driver.findElement(By.name("name_field")).sendKeys(data.get(1).get(1));
		driver.findElement(By.name("address_field")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("postcode_field")).sendKeys(data.get(3).get(1));
		driver.findElement(By.name("email_field")).sendKeys(data.get(4).get(1));
		driver.findElement(By.id("submit_message")).click();
	}

	@Then("^I check that the form has been submitted$")
	public void i_check_that_the_form_has_been_submitted() throws Throwable {
		Assert.assertTrue(driver.getTitle().contains("Contact Confirmation"));
	}
	
}
