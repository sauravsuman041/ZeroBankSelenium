package com.zerobank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.zerobank.basepage.BasePage;

public class AddPayeePage extends BasePage {

	public AddPayeePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}

	@FindBy(id = "onlineBankingMenu")
	WebElement onlineBankingMenuButton;
	
	public void clickOnlineBankingButton() {
		onClick(onlineBankingMenuButton);
	}
	
	@FindBy(id = "pay_bills_link")
	WebElement payBillsButton;
	
	public void goToPayBillsPage() {
		wait.until(ExpectedConditions.visibilityOf(payBillsButton));
		payBillsButton.click();
		wait.until(ExpectedConditions.urlContains("bank/pay-bills"));
	}
	
	@FindBy(xpath = "//a[text()='Add New Payee']")
	WebElement addPayeeButton;
	
	public void goToAddPayeeSection() {
		wait.until(ExpectedConditions.visibilityOf(addPayeeButton));
		addPayeeButton.click();
	}
	
	@FindBy(id = "np_new_payee_name")
	WebElement payeeName;
	
	@FindBy(id = "np_new_payee_address")
	WebElement payeeAddress;
	
	@FindBy(id = "np_new_payee_account")
	WebElement payeeAccountNo;
	
	@FindBy(id = "np_new_payee_details")
	WebElement payeeDetails;
	
	public void addPayeeName(String name) {
		wait.until(ExpectedConditions.visibilityOf(payeeName));
		payeeName.sendKeys(name);
	}
	
	public void addPayeeAddress(String address) {
		wait.until(ExpectedConditions.visibilityOf(payeeAddress));
		payeeAddress.sendKeys(address);
	}
	
	public void addPayeeAccountNo(Integer account) {
		wait.until(ExpectedConditions.visibilityOf(payeeAccountNo));
		payeeAccountNo.sendKeys(account.toString());
	}
	
	public void addPayeeDetails(String details) {
		wait.until(ExpectedConditions.visibilityOf(payeeDetails));
		payeeDetails.sendKeys(details);
	}
	
	@FindBy(id = "add_new_payee")
	WebElement addbtn;
	
	public void clickAddButton() {
		wait.until(ExpectedConditions.visibilityOf(addbtn));
		wait.until(ExpectedConditions.elementToBeClickable(addbtn));
		addbtn.click();	
	}
	
	@FindBy(id = "alert_content")
	WebElement addMessage;
	
	public String getSuccessMessage() {
		wait.until(ExpectedConditions.urlContains("pay-bills-new-payee"));
		wait.until(ExpectedConditions.visibilityOf(addMessage));
		return addMessage.getText();
	}
	
	public String getErrorMessage() {
		return addMessage.getText();
	}
	
	
}
