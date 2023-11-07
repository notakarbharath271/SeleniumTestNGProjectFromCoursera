package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	@FindBy(name="uid")
	private WebElement userID;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(name="btnLogin")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void loginToApplication(String userName,String pswd) {
		eleControl.clearText(userID);
		eleControl.clearText(password);
		eleControl.setText(userID, userName);
		eleControl.setText(password, pswd);
		eleControl.clickElement(loginbtn);
	}

}
