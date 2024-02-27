package com.tmb.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tmb.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {}
	
	public static String getScreenShot()
	{
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
