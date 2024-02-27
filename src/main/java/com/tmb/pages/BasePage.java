package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStratergy;
import com.tmb.factory.ExplictWaitFactory;

public class BasePage {
	
	protected void click(By by)
	{
		explicityWaitForElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendKeys(By by,String value, WaitStratergy waitstratergy)
	{
		ExplictWaitFactory.performExplictWait(waitstratergy, by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected void explicityWaitForElementToBeClickable(By by)
	{
		new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplictwait()))
		.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	protected void explicityWaitForelementToBePresent(By by)
	{
		new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplictwait()))
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	protected void click(By by,WaitStratergy wait)
	{
		ExplictWaitFactory.performExplictWait(wait, by);
		DriverManager.getDriver().findElement(by).click();
	}
	

}
