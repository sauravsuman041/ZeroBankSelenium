package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zerobank.hooks.Hooks;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSummaryStepDefinition {
	
	WebDriver driver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(driver);
	AccountSummaryPage page = new AccountSummaryPage(driver);
//	@Given("User should be logged in")
//	public void user_should_be_logged_in() throws InterruptedException {
//		driver = Hooks.getWebDriver();
//		loginPage = new LoginPage(driver);
//		page = new AccountSummaryPage(driver);
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
	
	@Given("User should be logged in with {string} and {string}")
	public void user_should_be_logged_in_with_and(String string, String string2) {
		//driver = Hooks.getWebDriver();
		//loginPage = new LoginPage(driver);
		loginPage.goToLoginPage();
		loginPage.setUsername(string);
		loginPage.setPassword(string2);
		loginPage.clickOnSignInButton();
		loginPage.directedToIndexPage();
	}


	@When("User clicks on ONLINE BANKING and then clicks on Account Summary")
	public void user_clicks_on_online_banking_and_then_clicks_on_account_summary() {
		//page = new AccountSummaryPage(driver);
	    page.clickOnlineBankingButton();
	    page.clickOnAccountSummaryButton();
	}

	@Then("User should be redirected to the Account Summary page")
	public void user_should_be_redirected_to_the_account_summary_page() {
	   if(driver.getCurrentUrl().contains("/bank/account-summary.html")) {
			Hooks.captureScreenshot("Test_04_SummaryPageVisible-Passed");
		}
		else {
			Hooks.captureScreenshot("Test_04_SummaryPageVisible-Failed");
		}
	   Assert.assertEquals(driver.getCurrentUrl(), "http://zero.webappsecurity.com/bank/account-summary.html");
	}

	@Given("User is on the Account Summary Page")
	public void user_is_on_the_account_summary_page() {
		page = new AccountSummaryPage(driver);
		page.clickOnlineBankingButton();
	    page.clickOnAccountSummaryButton();
	}

	@Then("Checking is Displayed")
	public void checking_is_displayed() {
		if(page.isLoanVisible()) {
			Hooks.captureScreenshot("Test_05_CheckingVisible-Passed");
		}
		else {
			Hooks.captureScreenshot("Test_05_CheckingVisible-Failed");
		}
		Assert.assertTrue(page.isCheckingVisible(),"Checking Option is not Visible");
	}

	@Then("Savings is Displayed")
	public void savings_is_displayed() {
		if(page.isLoanVisible()) {
			Hooks.captureScreenshot("Test_05_SavingsVisible-Passed");
		}
		else {
			Hooks.captureScreenshot("Test_05_SavingsVisible-Failed");
		}
		Assert.assertTrue(page.isSavingsVisible(),"Savings Option is not Visible");
	}

	@Then("Credit Card is Displayed")
	public void credit_card_is_displayed() {
		if(page.isLoanVisible()) {
			Hooks.captureScreenshot("Test_05_CreditCardVisible-Passed");
		}
		else {
			Hooks.captureScreenshot("Test_05_CreditCardVisible-Failed");
		}
		Assert.assertTrue(page.isCreditCardVisible(),"Credit Card Option is not Visible");
	}

	@Then("Loan is Displayed")
	public void loan_is_displayed() {
		if(page.isLoanVisible()) {
			Hooks.captureScreenshot("Test_05_LoanVisible-Passed");
		}
		else {
			Hooks.captureScreenshot("Test_05_LoanVisible-Failed");
		}
		Assert.assertTrue(page.isLoanVisible(),"Loan Option is not Visible");
	}


}
