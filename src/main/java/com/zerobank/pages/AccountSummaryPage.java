package com.zerobank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zerobank.basepage.BasePage;

public class AccountSummaryPage extends BasePage {
	
	public AccountSummaryPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	@FindBy(id = "onlineBankingMenu")
	WebElement onlineBankingMenuButton;
	
	@FindBy(id = "account_summary_link")
	WebElement accountSummaryButton;
	
	@FindBy(xpath = "//a[contains(text() , 'Checking')]")
	WebElement checkingWebElement;
	
	@FindBy(xpath = "//a[contains(text() , 'Savings')]")
	WebElement savingsWebElement;
	
	@FindBy(xpath = "//a[contains(text() , 'Credit Card')]")
	WebElement creditCardWebElement;
	
	@FindBy(xpath = "//a[contains(text() , 'Loan')]")
	WebElement loanWebElement;
	
	public void clickOnlineBankingButton() {
		onClick(onlineBankingMenuButton);
	}
	
	public void clickOnAccountSummaryButton() {
		onClick(accountSummaryButton);
	}
	

	public boolean isCheckingVisible() {
		return checkingWebElement.isDisplayed();
	}
	
	public boolean isSavingsVisible() {
		return savingsWebElement.isDisplayed();
	}
	
	public boolean isCreditCardVisible() {
		return creditCardWebElement.isDisplayed();
	}
	
	public boolean isLoanVisible() {
		return loanWebElement.isDisplayed();
	}
}
