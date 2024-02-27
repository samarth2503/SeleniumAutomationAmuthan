package com.tmb.test;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class HomePageTest extends BaseTest  {
	
	@Test
	public void test3()
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - youtube",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertEquals(title,title.contains("Google"));
	}

}
