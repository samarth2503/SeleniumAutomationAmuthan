package com.tmb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.tmb.ExtentReport.ExtentLogger;
import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import com.tmb.pages.OrangeHRMLoginPage;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginLogoutTest()
	{
		OrangeHRMLoginPage og = new OrangeHRMLoginPage();
		og.enterUserName("Admin");
		og.enterPassword("admin123");
		og.clickLogin();
	}

}
