package com.tmb.dpMeth;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.driver.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSample {
	
	public WebDriver driver = null;
	
	@BeforeSuite()
	public void setUp()
	{
		driver = new ChromeDriver();
		System.out.println("Thread id is "+ Thread.currentThread().getId());
	}
	
	@AfterSuite()
	public void tearDown()
	{
		driver.quit();
	}

}
