package com.tmb.ExtentReport;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	
	private ExtentReport() {}
	
	private static ExtentReports report;
	private static ExtentTest test;
	
	public static void initReport()
	{
		if(Objects.isNull(report))
		{
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			report.attachReporter(spark);
			
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Automation Report");	
		}
	}
	
	public static void flushReport()
	{
		if(Objects.nonNull(report))
		{
			report.flush();
		}
		
	}
	
	public static void createTest(String name)
	{
		ExtentTest test = report.createTest(name);
		ExtentManager.setTest(test);
		
	}
	
	public static void addAuthors(String[] authors)
	{
		for(String temp:authors)
		{
			ExtentManager.get().assignAuthor(temp);
		}
	}
	
	public static void addCategories(String[] categories)
	{
		for(String temp:categories)
		{
			ExtentManager.get().assignCategory(categories);
		}
	}

}
