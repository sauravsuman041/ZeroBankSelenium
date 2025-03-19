package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.zerobank.basepage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	
	@FindBy(id = "user_login")
	WebElement usernamWebElement;
	
	@FindBy(id = "user_password")
	WebElement passwordWebElement;
	
	@FindBy(name = "submit")
	WebElement submitWebElement;
	
	@FindBy(xpath = "//div[contains(text(),'Login and/or password are wrong.')]")
    WebElement errorMessage;

	public void goToLoginPage() {
		super.webDriver.findElement(By.id("signin_button")).click();
		super.wait.until(ExpectedConditions.urlContains("login"));
	}
	
	public void setUsername(String username) {
		//wait.until(ExpectedConditions.urlContains("login"));
		enterText(usernamWebElement, username);
	}
	public void setPassword(String password) {
		enterText(passwordWebElement, password);
	}
	public void clickOnSignInButton() {
		super.wait.until(ExpectedConditions.elementToBeClickable(submitWebElement));
		onClick(submitWebElement);
	}
	
	public void directedToIndexPage() {
		super.wait.until(ExpectedConditions.urlContains("auth/accept-certs"));
		super.webDriver.navigate().back();
		super.wait.until(ExpectedConditions.urlContains("index"));
	}
	
	public String getErrorMessage() {
		super.wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
	}

}
