package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zerobank.hooks.Hooks;
import com.zerobank.pages.FundTransferPage;
import com.zerobank.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundTransferStepDefinition {
	
	WebDriver driver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(driver);
	FundTransferPage page = new FundTransferPage(driver);
	
//	@Given("User should be logged in with username")
//	public void user_should_be_logged_in() throws InterruptedException {
//		driver = Hooks.getWebDriver();
//		loginPage = new LoginPage(driver);
//		page = new FundTransferPage(driver);
//		//driver.findElement(By.id("signin_button")).click();
//		loginPage.goToLoginPage();
//		loginPage.setUsername("username");
//		loginPage.setPassword("password");
//		loginPage.clickOnSignInButton();
//		loginPage.directedToIndexPage();
////		Thread.sleep(2000);
////		driver.navigate().back();
////		Thread.sleep(5000);
//		//Hooks.login();
//	}
//	
//	@Given("User is on the Fund Transfer Page")
//	public void user_is_on_the_fund_transfer_page() {
//		page = new FundTransferPage(driver);
//	    page.goToTransferFundsPage();
//	}
//
//	@When("User selects From Account and To Account")
//	public void user_selects_from_account_and_to_account() {
//		page.selectFromAccount("Brokerage");
//		page.selectToAccount("Checking");
//	}
//
//	@When("User enter a valid amount and submit")
//	public void user_enter_a_valid_amount_and_submit() {
//	    page.selectAmount(10);
//	    page.clickContinueAndThenSubmit();
//	}
//
//	@Then("User can see the transfer successfull message")
//	public void user_can_see_the_transfer_successfull_message() {
//	   Assert.assertEquals(page.getSuccessMessage(), "You successfully submitted your transaction.");
//	}
//
//	@When("Enter an amount greater than the available balance in From Account and submit")
//	public void enter_an_amount_greater_than_the_available_balance_and_submit() {
//		page.selectAmount(5000);
//	    page.clickContinueAndThenSubmit();
//	}
//
//	@Then("Error message Insufficient funds should be displayed")
//	public void error_message_insufficient_funds_should_be_displayed() {
//		Assert.assertEquals(page.getErrorMessage(), "Insufficient Balance.");
//	}
//
//	@When("Enter a negative value in the amount field and submit")
//	public void enter_a_negative_value_in_the_amount_field_and_submit() {
//		page.selectAmount(5000);
//	    page.clickContinueAndThenSubmit();
//	}
//
//	@Then("Error message Invalid amount entered should be displayed")
//	public void error_message_invalid_amount_entered_should_be_displayed() {
//		Assert.assertEquals(page.getErrorMessage(), "Invalid Amount.");
//	}
	
	
	@Given("User is on the Fund Transfer Page")
	public void user_is_on_the_fund_transfer_page() {
		//page = new FundTransferPage(driver);
		page.clickOnlineBankingButton();
	    page.goToTransferFundsPage();
	}
	
	@When("User selects {string} and {string}")
	public void user_selects_and(String string, String string2) {
		page.selectFromAccount(string);
		page.selectToAccount(string2);
	}

	@When("User enter a valid amount {int} and submit")
	public void user_enter_a_valid_amount_and_submit(Integer int1) {
		page.selectAmount(int1);
	    page.clickContinueAndThenSubmit();
	}

	@Then("User can see the transfer successfull {string}")
	public void user_can_see_the_transfer_successfull(String string) {
		if(page.getSuccessMessage().contains(string)) {
	    	Hooks.captureScreenshot("Test_06_FundTransferSuccess-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_06_FundTransferSuccess-Failed");
	    }
		Assert.assertEquals(page.getSuccessMessage(), string);
	}

	@When("Enter an amount {int} greater than the available balance in From Account and submit")
	public void enter_an_amount_greater_than_the_available_balance_in_from_account_and_submit(Integer int1) {
		page.selectAmount(int1);
	    page.clickContinueAndThenSubmit();
	}

	@Then("Error {string} should be displayed")
	public void error_should_be_displayed(String string) {
		if(page.getErrorMessage().contains(string)) {
	    	Hooks.captureScreenshot("Test_07&08_FundTransferError-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_07&08_FundTransferError-Failed");
	    }
		Assert.assertEquals(page.getErrorMessage(), string ,"Error message is not displayed");
	}

	@When("Enter a negative value in the amount {int} field and submit")
	public void enter_a_negative_value_in_the_amount_field_and_submit(Integer int1) {
		page.selectAmount(int1);
	    page.clickContinueAndThenSubmit();
	}

}
