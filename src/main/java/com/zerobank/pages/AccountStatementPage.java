package com.zerobank.pages;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.zerobank.basepage.BasePage;

public class AccountStatementPage extends BasePage {

	public AccountStatementPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	@FindBy(id = "onlineBankingMenu")
	WebElement onlineBankingMenuButton;
	
	public void clickOnlineBankingButton() {
		onClick(onlineBankingMenuButton);
	}
	
	@FindBy(id = "online_statements_link")
	WebElement onlineStatementButton;
	
	public void goToOnlineStatementPage() {
		wait.until(ExpectedConditions.visibilityOf(onlineStatementButton));
		onlineStatementButton.click();
		wait.until(ExpectedConditions.urlContains("bank/online-statements"));
	}

	@FindBy(id = "os_accountId")
	WebElement account;
	
	public void selectAccount(String acc) {
		wait.until(ExpectedConditions.visibilityOf(account));
		account.sendKeys(acc);
	}
	
	//@FindBy(xpath = "//a[text()='" + targetDay + "']")
	
	public void selectYear(Integer year) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + year.toString() + "']")));
		webDriver.findElement(By.xpath("//a[text()='" + year.toString() + "']")).click();
	}
	
	public void downloadPDF(String pdf) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + pdf + "']")));
		webDriver.findElement(By.xpath("//a[text()='" + pdf + "']")).click();
	}
	
	public boolean isPdfDownloaded(String fileName) {
        String downloadPath = System.getProperty("user.home") + "/Downloads/" + fileName;
        Path path = Paths.get(downloadPath);
        try {
            Thread.sleep(2000);
            return Files.exists(path);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
