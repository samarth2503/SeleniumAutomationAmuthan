package com.tmb.ExtentReport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();
	
	static void setTest(ExtentTest test)
	{
		exTest.set(test);
	}
	
	static ExtentTest get()
	{
		return exTest.get();
	}
	
	static void unload()
	{
		exTest.remove();
	}

}
