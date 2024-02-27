package com.tmb.ExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message)
	{
		ExtentManager.get().pass(message);
	}
	
	public static void fail(String message)
	{
		ExtentManager.get().fail(message);
	}
	
	public static void skip(String message)
	{
		ExtentManager.get().skip(message);
	}
	
	public static void info(String message)
	{
		ExtentManager.get().info(message);
	}
	
	public static void pass(String message, boolean isScreenshotNeeded) throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equals("yes") &&
				isScreenshotNeeded)
		{
			ExtentManager.get().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
	}
	
	public static void fail(String message, boolean isScreenshotNeeded) throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equals("yes") &&
				isScreenshotNeeded)
		{
			ExtentManager.get().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
	}
	
	public static void skip(String message, boolean isScreenshotNeeded) throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equals("yes") &&
				isScreenshotNeeded)
		{
			ExtentManager.get().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
	}
	
	public static String getBase64Image()
	{
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}


