package com.zerobank.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zerobank.hooks.Hooks;
import com.zerobank.pages.AccountStatementPage;
import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStatementStepDefintion {
	
	WebDriver driver = Hooks.getWebDriver();
	LoginPage loginPage = new LoginPage(driver);
	AccountStatementPage page = new AccountStatementPage(driver);
	
	@When("User navigates to the online statement section")
	public void user_navigates_to_the_online_statement_section() {
	    page.clickOnlineBankingButton();
	    page.goToOnlineStatementPage();
	}

	@When("selects an account {string} and year {int}")
	public void selects_an_account_year_and_a_pdf_to_download(String string, Integer int1) {
	    page.selectAccount(string);
	    page.selectYear(int1);
	}

	@When("clicks on the pdf {string} to download")
	public void clicks_on_the_pdf_to_download(String string) {
	    page.downloadPDF(string);
	}

	@Then("the pdf {string} should be downloaded successfully")
	public void the_pdf_should_be_downloaded_successfully(String string) {
	    if(page.isPdfDownloaded(string)) {
	    	Hooks.captureScreenshot("Test_14_PdfDownload-Passed");
	    }
	    else {
	    	Hooks.captureScreenshot("Test_14_PdfDownload-Failed");
	    }
	    Assert.assertTrue(page.isPdfDownloaded(string));
	}


}
