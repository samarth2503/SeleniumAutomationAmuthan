package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStratergy;

public class OrangeHRMHomePage extends BasePage {
	
	private final By link_welcome = By.id("welcome");
	private final By link_logout = By.linkText("Logout");
	
	public OrangeHRMHomePage clickWelcome()
	{
		click(link_welcome,WaitStratergy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout()
	{
		click(link_logout, WaitStratergy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}
	
	public String getTitle()
	{
		return DriverManager.getDriver().getTitle();
	}



}
