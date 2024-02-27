package com.tmb.Listners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.ExtentReport.ExtentLogger;
import com.tmb.ExtentReport.ExtentReport;
import com.tmb.annotations.FrameworkAnnotations;

public class ListnerClass implements ITestListener, ISuiteListener {
	
	@Override
	public void onStart(ISuite suite)
	{
		ExtentReport.initReport();
	}
	
	
	@Override
	public void onFinish(ISuite suite)
	{
		ExtentReport.flushReport();
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
