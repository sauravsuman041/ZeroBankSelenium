package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zerobank.hooks.Hooks;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayBillsStepDefinition {
	
	WebDriver driver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(driver);
	PayBillsPage page = new PayBillsPage(driver);
	
	@Given("User is on the Bill Payment Page")
	public void user_is_on_the_bill_payment_page() {
	   page.clickOnlineBankingButton();
	   page.goToPayBillsPage();
	}

	@When("User selects the {string} Account and {string}")
	public void user_selects_the_account_and(String string, String string2) {
	    page.selectPayee(string);
	    page.selectFromAccount(string2);
	}

	@When("User enter a valid amount {int} ,select a {string} and click pay")
	public void user_enter_a_valid_amount_select_a_and_click_pay(Integer int1, String string){
	    page.selectAmount(int1);
	    page.selectCurrentDate(string);
	    //page.writeDescription("paybill");
	    page.clickPayButton();
	}

	@Then("User can see the payment successfull {string}")
	public void user_can_see_the_payment_successfull(String string) {
	    if(page.getSuccessMessage().contains(string)) {
			   Hooks.captureScreenshot("Test_09&10_PayBillsSuccess-Passed");
		   }
		   else {
			   Hooks.captureScreenshot("Test_09&10_PayBillsSuccess-Failed");
		 }
	    Assert.assertEquals(page.getSuccessMessage(), string);
	}

	@When("User select a {string} and click pay")
	public void user_select_a_and_click_pay(String string) {
	    page.selectCurrentDate(string);
	    //page.writeDescription("paybill");
	    page.clickPayButton();
	}

	@Then("User can see the error {string}")
	public void user_can_see_the_error(String string) {
	   if(page.getErrorMessage().contains(string)) {
		   Hooks.captureScreenshot("Test_11_PayBillsError-Passed");
	   }
	   else {
		   Hooks.captureScreenshot("Test_11_PayBillsError-Failed");
	   }
	   Assert.assertEquals(page.getErrorMessage(), string ,"Error message is not displayed");
	}

}
