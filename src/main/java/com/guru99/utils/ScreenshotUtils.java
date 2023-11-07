package com.guru99.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	private TakesScreenshot screenshot;
	
	public ScreenshotUtils(WebDriver driver) {
		screenshot = (TakesScreenshot)driver;
	}
	
	public void captureAndSaveScreenshot(String filename) throws Exception {
		File imgFile , temFile;
		imgFile = new File(filename);
		if(imgFile.exists()) {
			throw new Exception("File already exist");
		}
		temFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(temFile, imgFile);
	}
	

}
