package com.tmb.factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStratergy;

public class ExplictWaitFactory {
	
	public static void performExplictWait(WaitStratergy wait, By by)
	{
		if(wait == WaitStratergy.CLICKABLE) {
			new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplictwait()))
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(wait == WaitStratergy.PRESENCE){
			new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplictwait()))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(wait == WaitStratergy.VISIBLE) {
			new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplictwait()))
			.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		}
		else if(wait == WaitStratergy.NONE) {
			System.out.println("not doing anything...");
		}
	}

}
