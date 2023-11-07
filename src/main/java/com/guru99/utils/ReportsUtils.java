package com.guru99.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsUtils {
	
	ExtentHtmlReporter extentHtmlReporter;
	
	ExtentReports extentReports;
	
	ExtentTest extentTest;
	
	public ReportsUtils(String reportPath) {
		extentHtmlReporter = new ExtentHtmlReporter(reportPath);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	public void createATestCase(String testCaseName) {
		extentTest = extentReports.createTest(testCaseName);
	}
	
	public void addTestLog(Status status,String comment) {
		extentTest.log(status, comment);
	}
	
	public void attachScreenshotToReports(String filepath) throws IOException {
		extentTest.addScreenCaptureFromPath(filepath);
	}
	
	public void flushReports() {
		extentReports.flush();
	}

}
