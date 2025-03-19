package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zerobank.hooks.Hooks;
import com.zerobank.pages.AddPayeePage;
import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPayeeStepDefinition {
	
	WebDriver driver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(driver);
	AddPayeePage page = new AddPayeePage(driver);
	
	@Given("User navigate to Add New Payee Section.")
	public void user_navigate_to_add_new_payee_section() {
	    page.clickOnlineBankingButton();
	    page.goToPayBillsPage();
	    page.goToAddPayeeSection();
	}

	@When("User Enter the payee details {string} {string} {int}")
	public void user_enter_the_payee_details(String string, String string2, Integer int1) {
	    page.addPayeeName(string);
	    page.addPayeeAddress(string2);
	    page.addPayeeAccountNo(int1);
	}

	@When("clicks the add button")
	public void clicks_the_add_button() {
	    page.clickAddButton();
	}

	@Then("User can see the Payee added successfully {string} {string} {string}")
	public void user_can_see_the_payee_added_successfully(String string, String string2, String string3) {
	    if(page.getSuccessMessage().contains(string2)) {
	    	Hooks.captureScreenshot("Test_12_PayeeAddingSuccess-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_12_PayeeAddingSuccess-Failed");
	    }
	    Assert.assertEquals(page.getSuccessMessage(), string + string2 + string3);
	}

	@When("User Enter the payee with missing details {string} {int}")
	public void user_enter_the_payee_with_missing_details(String string, Integer int1) {
	    page.addPayeeAddress(string);
	    page.addPayeeAccountNo(int1);
	}

	@Then("User can see the error meesage {string}")
	public void user_can_see_the_error_meesage(String string) {
	    if(page.getErrorMessage().contains(string)) {
	    	Hooks.captureScreenshot("Test_13_PayeeAddingError-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_13_PayeeAddingError-Failed");
	    }
	    Assert.assertEquals(page.getErrorMessage(), string ,"Error message is not displayed");
	}

}
