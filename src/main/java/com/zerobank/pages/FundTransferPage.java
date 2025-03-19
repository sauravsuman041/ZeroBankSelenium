package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.zerobank.basepage.BasePage;

public class FundTransferPage extends BasePage{

	public FundTransferPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	@FindBy(id = "onlineBankingMenu")
	WebElement onlineBankingMenuButton;
	
	@FindBy(id = "tf_fromAccountId")
	WebElement fromAccountMenu;
	
	@FindBy(id = "tf_toAccountId")
	WebElement toAccountMenu;
	
	@FindBy(id = "transfer_funds_link")
	WebElement transferFundsButton;
	
	@FindBy(id = "tf_amount")
	WebElement amount;
	
	@FindBy(id = "tf_description")
	WebElement description;

	@FindBy(id = "btn_submit")
	WebElement submitButton;
	
	@FindBy(xpath = "//div[contains(text() , 'You successfully submitted your transaction.')]")
	WebElement successfulTransferMessage;
	
	@FindBy(xpath = "//a[contains(text() , 'Savings')]")
	WebElement savingsWebElement;
	
	@FindBy(xpath = "//a[contains(text() , 'Credit Card')]")
	WebElement creditCardWebElement;
	
	@FindBy(xpath = "//a[contains(text() , 'Loan')]")
	WebElement loanWebElement;
	
	public void clickOnlineBankingButton() {
		onClick(onlineBankingMenuButton);
	}
	
	public void goToTransferFundsPage() {
		//wait.until(ExpectedConditions.visibilityOf(transferFundsButton));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("transfer_funds_link")));
		transferFundsButton.click();
	}
	
	public void selectFromAccount(String from) {
		fromAccountMenu.sendKeys(from);
	}
	
	public void selectToAccount(String to) {
		toAccountMenu.sendKeys(to);
	}
	
	public void selectAmount(Integer amt) {
		amount.sendKeys(amt.toString());
	}
	
	public void writeDescription(String message) {
		description.sendKeys(message);
	}
	
	public void clickContinueAndThenSubmit() {
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].click();", submitButton);
		
		//submitButton.click();
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		//submitButton.click();
		js.executeScript("arguments[0].click();", submitButton);
	}
	
	public String getSuccessMessage() {
		wait.until(ExpectedConditions.urlContains("transfer-funds-confirm"));
		wait.until(ExpectedConditions.visibilityOf(successfulTransferMessage));
		return successfulTransferMessage.getText();
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.urlContains("transfer-funds-confirm"));
		wait.until(ExpectedConditions.visibilityOf(successfulTransferMessage));
		return successfulTransferMessage.getText();
	}
	
	

}
