package com.zerobank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.zerobank.basepage.BasePage;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	@FindBy(xpath = "//i[@class='icon-user']")
	WebElement usernameDropdown;
	
	@FindBy(id = "logout_link")
	WebElement logoutButton;
	
	public void logout() {
		usernameDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
		wait.until(ExpectedConditions.urlContains("index"));
	}
	
	public void goToPreviousPage() {
		wait.until(ExpectedConditions.invisibilityOf(usernameDropdown));
		webDriver.navigate().back();
	}
	
	@FindBy(id = "signin_button")
	WebElement signInButton;
	
	public boolean isSignInButtonDisplayed() {
		return signInButton.isDisplayed();
	}

}
