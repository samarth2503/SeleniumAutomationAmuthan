package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	public static WebDriver driver;
	
	public static void initDriver(String browser)
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			if(browser.equals("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equals("Firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			
			DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
