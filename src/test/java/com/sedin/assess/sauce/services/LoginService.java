package com.sedin.assess.sauce.services;

import com.sedin.assess.test.assertion.TestAssertions;
import com.sedin.assess.utils.ReadProperties;

public class LoginService extends ProjectSpecificService {
	
	public LoginService enterUserName(String uName) {
		type(getWebElement(ReadProperties.readObjectRepositories("LoginService", "sauce.demo.login.username.filed")), uName);
		return this;		
	}
	
	public LoginService enterPassword(String pwd) {
		type(getWebElement(ReadProperties.readObjectRepositories("LoginService", "sauce.demo.login.password.filed")), pwd);
		return this;		
	}
	
	public ProductListService clickOnTheLoginButton() {
		click(getWebElement(ReadProperties.readObjectRepositories("LoginService", "sauce.demo.login.login.button")));
		return new ProductListService();
	}
	
	public LoginService validateTheInvalidUserCredentialsErrorMessage() {
		TestAssertions.assertTheExactText("Epic sadface: Username and password do not match any user in this service", getText(getWebElement(ReadProperties.readObjectRepositories("LoginService", "sauce.demo.login.error.text"))).trim());
		return this;
	}

}