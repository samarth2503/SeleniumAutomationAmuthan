package com.tmb.test;

import java.lang.reflect.Method;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.ExtentReport.ExtentManager;
import com.tmb.ExtentReport.ExtentReport;
import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	
	protected BaseTest()
	{
		
	}
	
	@BeforeSuite()
	public void beforeSuite()
	{
		ExtentReport.initReport();
	}
	
	@AfterSuite()
	public void afterSuite()
	{
		ExtentReport.flushReport();
	}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void setUp(Object[] data,Method m) throws Exception
	{
		ExtentReport.createTest(m.getName());
		Map<String,String> hmap = (Map<String,String>)data[0];
		Driver.initDriver(hmap.get(hmap.get("Browser")));
		DriverManager.getDriver().manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quitDriver();
	}

}
