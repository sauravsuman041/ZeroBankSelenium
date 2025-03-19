package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.zerobank.hooks.Hooks;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.LogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepdefinition {
	
	WebDriver driver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(driver);
	LogoutPage page = new LogoutPage(driver);

	@When("User clicks the logout button")
	public void user_clicks_the_logout_button() {
	    page.logout();
	}

	@Then("User is redirected to the home page {string}")
	public void user_is_redirected_to_the_home_page(String string) {
		if(driver.getCurrentUrl().contains(string)) {
	    	Hooks.captureScreenshot("Test_15_LogoutSuccess-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_15_LogoutSuccess-Failed");
	    }
		Assert.assertEquals(driver.getCurrentUrl(), string);
	}

	@When("User tries to navigate the previous page by clicking the browser back button")
	public void user_tries_to_navigate_the_previous_page_by_clicking_the_browser_back_button() {
	    page.goToPreviousPage();
	}

	@Then("User is not able to access the previous page")
	public void user_is_not_able_to_access_the_previous_page() {
	    if(page.isSignInButtonDisplayed()) {
	    	Hooks.captureScreenshot("Test_16_SessionExpiry-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_16_SessionExpiry-Failed");
	    }
	    Assert.assertTrue(page.isSignInButtonDisplayed());
	}
}
