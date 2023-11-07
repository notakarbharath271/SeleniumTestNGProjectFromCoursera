package com.guru99.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.guru99.constants.FrameworkConstants;
import com.guru99.pages.LoginPage;
import com.guru99.utils.ReportsUtils;
import com.guru99.utils.ScreenshotUtils;
import com.guru99Libs.utils.ReadConfig;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ElementControl;

public class BaseTest {
	
	WebDriver driver;
	String url;
	CommonDriver commonDriver;
	LoginPage loginpage;
	ElementControl eleControl;
	Properties prop ;
	ReportsUtils reportsUtils;
	ScreenshotUtils screenshotUtils;
	
	@BeforeSuite
	public void preConditions() throws Exception {
		prop = ReadConfig.readProperties(FrameworkConstants.CONFIG_FILE_PATH);
		reportsUtils = new ReportsUtils(FrameworkConstants.REPORTS_FOLDER_PATH+"\\guru99report.html");
	}
	
	@BeforeClass
	public void lanchApplication() throws Exception {

		commonDriver=new CommonDriver(prop.getProperty("browser"));
		driver = commonDriver.getDriver();
		loginpage =  new LoginPage(driver);
		eleControl = new ElementControl(driver);
		screenshotUtils = new ScreenshotUtils(driver);
		commonDriver.navigateToUrl(prop.getProperty("url"));
		
	}
	@AfterMethod
	public void postTestAction(ITestResult iTestResult) throws Exception {
		String testcaseName = iTestResult.getName();
		long executionTime = System.currentTimeMillis();
		String screenShotFileName = FrameworkConstants.SCREENSHOT_FOLDER_PATH+"\\"+testcaseName+executionTime+".jpeg";
		 if(iTestResult.getStatus()== ITestResult.FAILURE) {
			 reportsUtils.addTestLog(Status.FAIL, "One or more steps failed");
			 screenshotUtils.captureAndSaveScreenshot(screenShotFileName);
			 reportsUtils.attachScreenshotToReports(screenShotFileName);
		 }
	}
	
	@AfterClass
	public void tearDown() {
		commonDriver.closeAllBrowsers();
	}
	
	@AfterSuite
	public void postTearDown() {
		reportsUtils.flushReports();
	}

}
