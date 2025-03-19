package com.zerobank.hooks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zerobank.runners.TestNGRunner;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

   public static  WebDriver webDriver;
	
    
     
	@Before
	public void setUp() {
		String browser = TestNGRunner.browser;
		String url = TestNGRunner.appUrl;
		switch(browser.toLowerCase()) {
		
		case "edge":
			webDriver = new EdgeDriver();
			break;
		case "chrome":
			webDriver =  new ChromeDriver();
			break;
		case "firefox":
			webDriver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser not supported");
		}
		
		webDriver.get(url);
		webDriver.manage().window().maximize();

	}
	
//	public static void login() throws InterruptedException {
//		webDriver.findElement(By.id("signin_button")).click();
//		webDriver.findElement(By.id("user_login")).sendKeys("username");
//		webDriver.findElement(By.id("user_password")).sendKeys("password");
//		webDriver.findElement(By.id("submit")).click();
//		Thread.sleep(2000);
//		webDriver.navigate().back();
//		Thread.sleep(5000);
//	}
	
	@After
	public void teardown() {
		webDriver.close();
	}
	
	 public static WebDriver getWebDriver() {
	 		return webDriver;
	 	}
	
	 public static void captureScreenshot(String screenshotName) {
	    	String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    	String path = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + currentDate + ".png";
	    
	    	TakesScreenshot screenshot = (TakesScreenshot) webDriver;
	    	File source = screenshot.getScreenshotAs(OutputType.FILE);
	    	File destination=new File(path);
	    	
		    try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
