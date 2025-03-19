package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zerobank.hooks.Hooks;
import com.zerobank.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	WebDriver driver;
	LoginPage page;
	
	@Given("User is on Zero Bank login page")
	public void user_is_on_zero_bank_login_page() {
	    driver = Hooks.getWebDriver();
	    page = new LoginPage(driver);
	    //driver.findElement(By.id("signin_button")).click();
	    page.goToLoginPage();
	}

	@When("User enters {string} and {string} and click on SignIn button")
	public void user_enters_and_and_click_on_sign_in_button(String string, String string2) {
	    page.setUsername(string);
	    page.setPassword(string2);
	    page.clickOnSignInButton();
	}

	@Then("User should be redirected to the Home page")
	public void user_should_be_redirected_to_the_account_summary_page(){
//		Thread.sleep(2000);
//		driver.navigate().back();
//		Thread.sleep(5000);
		page.directedToIndexPage();
		if(driver.getCurrentUrl().contains("/index.html")) {
			Hooks.captureScreenshot("Test_01_LoginSuccess-Passed");
		}
		else {
			Hooks.captureScreenshot("Test_01_LoginSuccess-Failed");
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/index.html");
	}
	
	@Then("User should see error message {string}")
	public void user_should_see_error_message(String string) {
		    if(page.getErrorMessage().contains(string)) {
		    	Hooks.captureScreenshot("Test_02&03_LoginErrorDisplayed-Passed");
		    }
		    else {
		    	Hooks.captureScreenshot("Test_02&03_LoginErrorDisplayed-Failed");
		    }
		    Assert.assertEquals(page.getErrorMessage(),string);
	}

	@When("User click on SignIn button without entering credentials")
	public void user_click_on_sign_in_button_without_entering_credentials() {
		page.clickOnSignInButton();
	}

}
