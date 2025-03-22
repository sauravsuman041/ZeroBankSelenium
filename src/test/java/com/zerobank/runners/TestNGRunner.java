package com.zerobank.runners;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.zerobank.utils.ExcelReader;

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
		
		
		
		Map<String, String> featureToExcelMap = new HashMap<>();
		featureToExcelMap.put(System.getProperty("user.dir")+"\\src\\test\\resources\\features\\06_AccountStatement.feature", System.getProperty("user.dir")+"\\test-data\\onlineStatement_data.xlsx");
		//featureToExcelMap.put(System.getProperty("user.dir")+"\\src\\test\\resources\\features\\01_Login.feature", System.getProperty("user.dir")+"\\test-data\\userLogin_data.xlsx");
		//featureToExcelMap.put(System.getProperty("user.dir")+"\\src\\test\\resources\\features\\03_FundTransfer.feature", System.getProperty("user.dir")+"\\test-data\\fundTransfer_data.xlsx");
		
		for(Map.Entry<String, String> entry : featureToExcelMap.entrySet()) {
			String featurePath = entry.getKey();
            String excelPath = entry.getValue();
            ExcelReader.updateFeatureFileWithData(excelPath, featurePath);

		}
		
	}
		
}
