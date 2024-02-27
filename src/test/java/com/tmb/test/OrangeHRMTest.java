package com.tmb.test;

import org.testng.annotations.Test;

import java.util.Map;

import org.assertj.core.api.Assertions;

import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataProviderUtil;

public final class OrangeHRMTest extends BaseTest {
	
	private OrangeHRMTest() {}
	
	@Test(dataProvider="getData",dataProviderClass=DataProviderUtil.class)
	public void loginLogoutTest(Map<String,String> hm)
	{
		String title = new OrangeHRMLoginPage()
		.enterUserName(hm.get("username")).enterPassword(hm.get("password")).clickLogin()
		.clickWelcome().clickLogout()
		.getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	@Test(dataProvider="getData",dataProviderClass=DataProviderUtil.class)
	public void newTest(Map<String,String> hm)
	{
		String title = new OrangeHRMLoginPage()
		.enterUserName(hm.get("username")).enterPassword(hm.get("password")).clickLogin()
		.clickWelcome().clickLogout()
		.getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}

}
