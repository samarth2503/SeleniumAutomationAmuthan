package com.tmb.Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public class RetryFailedTest implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		try {
			if(ReadPropertyFile.getValue(ConfigProperties.RETRYFAILEDTEST).equals("yes"))
			{
				if(count<retries)
				{
					count ++;
					return true;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
