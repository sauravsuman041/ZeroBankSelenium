package com.zerobank.basepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver webDriver;
	public WebDriverWait wait;

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver,Duration.ofSeconds(20));
	}

	public WebElement findWebElement(By locator) {
		return webDriver.findElement(locator);
	}
	
	public List<WebElement> findWebElements(By locator) {
		return webDriver.findElements(locator);
	}
	
	public void enterText(WebElement element , String text) {
		element.sendKeys(text);
	}
	
	public void onClick(WebElement element) {
		element.click();
	}
	
}
