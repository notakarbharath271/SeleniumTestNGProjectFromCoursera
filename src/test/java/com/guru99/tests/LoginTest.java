package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest{
	
	@Parameters({"userName","password"})
	@Test
	public void loginWithValidCredentials(@Optional String username,@Optional String password) {
		
		reportsUtils.createATestCase("login With Valid Credentials");
		reportsUtils.addTestLog(Status.INFO, "Performe login");
		loginpage.loginToApplication(username, password);
		String actualTitle = eleControl.getTitle();
		String expectedTitel = "Guru99 Bank Manager HomePage ";
		
		Assert.assertEquals(actualTitle, expectedTitel, "actualTitle : "+actualTitle+" is not matching with expectedTitel: "+expectedTitel);
		reportsUtils.addTestLog(Status.INFO, "comparing actual and expected value");
	}

}
