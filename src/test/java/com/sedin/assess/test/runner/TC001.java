package com.sedin.assess.test.runner;

import org.junit.Test;

import com.sedin.assess.sauce.services.LoginService;
import com.sedin.assess.selenium.api.base.SeleniumBase;

public class TC001 extends SeleniumBase {
	
	@Test
	public void test_TC001() {
		launchBrowser();
		open("https://www.saucedemo.com/");
		new LoginService().enterUserName("standard_user").enterPassword("secret_sauce").clickOnTheLoginButton().extractTheProductNameAndPrice()
		    .validateTheProductPrice();
	}

}