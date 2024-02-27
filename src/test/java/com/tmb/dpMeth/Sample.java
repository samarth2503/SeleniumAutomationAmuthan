package com.tmb.dpMeth;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public class Sample extends BaseSample{
	
	@DataProvider(parallel=true)
	public Object[] dpMeth()
	{
//		Map<String,String> hm = new HashMap<String,String>();
//		hm.put("a1", "a11");
//		hm.put("a2", "a12");
//		
//		Map<String,String> hm1 = new HashMap<String,String>();
//		hm1.put("a1", "a21");
//		hm1.put("a2", "a22");
//		
//		Map<String,String> hm2 = new HashMap<String,String>();
//		hm2.put("a1", "a31");
//		hm2.put("a2", "a32");
		return new Object[] {"https://www.geeksforgeeks.org/","https://www.seleniumeasy.com/"
				,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login","https://github.com/"};
	}
	
	@Test(dataProvider="dpMeth")
	public void test2(String url) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Title is "+title+" : "+"Thread id is "+ Thread.currentThread().getId());
	}

}
