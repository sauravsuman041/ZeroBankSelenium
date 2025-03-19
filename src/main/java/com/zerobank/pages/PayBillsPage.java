package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.zerobank.basepage.BasePage;

public class PayBillsPage extends BasePage {

	public PayBillsPage(WebDriver webDriver) {
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
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("payBillsButton")));
		payBillsButton.click();
		wait.until(ExpectedConditions.urlContains("bank/pay-bills"));
	}

	@FindBy(id = "sp_payee")
	WebElement payeeMenu;
	
	@FindBy(id = "sp_account")
	WebElement fromAccountMenu;
	
	public void selectFromAccount(String from) {
		wait.until(ExpectedConditions.visibilityOf(fromAccountMenu));
		fromAccountMenu.sendKeys(from);
	}
	
	public void selectPayee(String payee) {
		wait.until(ExpectedConditions.visibilityOf(payeeMenu));
		payeeMenu.sendKeys(payee);
	}
	
	@FindBy(id = "sp_amount")
	WebElement amount;
	
	public void selectAmount(Integer amt) {
		amount.sendKeys(amt.toString());
	}
	
	@FindBy(id = "sp_date")
	WebElement date;
	
	public void selectCurrentDate(String dt) {
		date.sendKeys(dt);
//		String targetDay = dt.split("-")[2];
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + targetDay + "']")));
//		webDriver.findElement(By.xpath("//a[text()='" + targetDay + "']")).click();
	}
	
	public void selectFutureDate(String dt){
		String targetMonth = dt.split("-")[1];
        String targetYear = dt.split("-")[0];
        String targetDay = dt.split("-")[2];
		
        date.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-title")));
		while (true) {
            String displayedMonthYear = webDriver.findElement(By.className("ui-datepicker-title")).getText();
            if (displayedMonthYear.contains(targetMonth) && displayedMonthYear.contains(targetYear)) {
                break;
            }
            webDriver.findElement(By.xpath("//a[@title='Next']")).click();
        }
		webDriver.findElement(By.xpath("//a[text()='" + targetDay + "']")).click();
	}
	
//	
//	public void selectPastDate(String dt) {
//		String targetMonth = dt.split("-")[1];
//        String targetYear = dt.split("-")[0];
//        String targetDay = dt.split("-")[2];
//		
//		while (true) {
//            String displayedMonthYear = webDriver.findElement(By.className("ui-datepicker-title")).getText();
//            if (displayedMonthYear.contains(targetMonth) && displayedMonthYear.contains(targetYear)) {
//                break;
//            }
//            webDriver.findElement(By.xpath("//a[@title='Prev']")).click();
//        }
//		webDriver.findElement(By.xpath("//a[text()='" + targetDay + "']")).click();
//	}
	
	
	@FindBy(id = "sp_description")
	WebElement description;
	
	public void writeDescription(String message) {
		description.sendKeys(message);
	}
	
	@FindBy(id = "pay_saved_payees")
	WebElement paybtn;
	
	public void clickPayButton() {
		wait.until(ExpectedConditions.visibilityOf(paybtn));
		wait.until(ExpectedConditions.elementToBeClickable(paybtn));
		paybtn.click();	
	}
	
	
	@FindBy(id = "alert_content")
	WebElement payMessage;
	
	public String getSuccessMessage() {
		wait.until(ExpectedConditions.urlContains("pay-bills-saved-payee"));
		wait.until(ExpectedConditions.visibilityOf(payMessage));
		return payMessage.getText();
	}
	
	public String getErrorMessage() {
		return payMessage.getText();
	}
}
