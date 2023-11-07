package com.guru99.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementControl;

public class BasePage {
	
	WebDriver driver;
	public ElementControl eleControl;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		eleControl= new ElementControl(driver);
	}

}
