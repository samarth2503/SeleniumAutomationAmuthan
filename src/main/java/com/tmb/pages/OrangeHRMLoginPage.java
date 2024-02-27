package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStratergy;

public final class OrangeHRMLoginPage extends BasePage{
	
	private final By textbox_username = By.name("username");
	private final By textbox_password = By.name("password");
	private final By button_login = By.xpath("//button[@type='submit']");
	
	public OrangeHRMLoginPage enterUserName(String name)
	{
		sendKeys(textbox_username,name,WaitStratergy.PRESENCE);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password)
	{
		sendKeys(textbox_password,password,WaitStratergy.PRESENCE);
		return this;
	}
	
	public OrangeHRMHomePage clickLogin()
	{
		click(button_login);
		return new OrangeHRMHomePage();
	}
	
	public String getTitle()
	{
		return DriverManager.getDriver().getTitle();
	}

}
