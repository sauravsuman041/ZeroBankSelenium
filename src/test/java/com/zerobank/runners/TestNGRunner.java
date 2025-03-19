package com.zerobank.runners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/resources/features/",
		
		glue = {"com.zerobank.hooks","com.zerobank.steps"},
		
		tags = "@validlogin or @invalidlogin or @missingcredentials or "
				+ "@accountSummaryPageLoading or @validatingAccountTypes or "
				+ "@successfulTransfer or @insufficientBalanceTransfer or @negativeAmountTransfer or "
				+ "@successfulPayment or @missingAmount or "
				+ "@succesfullAddingPayee or @missingDetailAddingPayee or "
				+ "@logout or @sessionExpiry or @accountStatement" ,
		plugin = {
					"pretty",
					"html:target/CucumberReport/cucumber-reports.html",
					"json:target/CucumberReport/cucumber-reports.json",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
				  },
		monochrome = true
		
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
	public static String browser;
	public static String appUrl;
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void setUp(@Optional("chrome")String browserParam , @Optional("http://zero.webappsecurity.com/")String urlParam) {
		
		browser = browserParam;
		appUrl = urlParam;
	}
}
