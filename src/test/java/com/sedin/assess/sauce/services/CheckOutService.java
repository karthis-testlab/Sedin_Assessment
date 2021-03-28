package com.sedin.assess.sauce.services;

import com.sedin.assess.test.assertion.TestAssertions;
import com.sedin.assess.utils.ReadProperties;

public class CheckOutService extends ProjectSpecificService {
	
	public CheckOutService enterTheFirstName(String fName) {
		type(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.firstname.field")), fName);
		return this;
	}
	
	public CheckOutService enterTheLastName(String lName) {
		type(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.lastname.field")), lName);
		return this;
	}
	
	public CheckOutService enterZipCode(String zipCode) {
		type(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.zipcode.field")), zipCode);
		return this;
	}
	
	public CheckOutService clickOnTheCheckoutButton() {
		click(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.checkout.button")));
		return this;		
	}
	
	public CheckOutService validateProductName() {	
        TestAssertions.assertTheExactText(productName, getText(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.productname.text"))));
		return this;
	}

	public CheckOutService validateProductPrice() {		
		TestAssertions.assertTheExactText(price, getText(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.productprice.text"))));
		return this;
	}
	
	public CheckOutCompleteService clickOnTheFinishButton() {
		click(getWebElement(ReadProperties.readObjectRepositories("CheckOutService", "sauce.demo.checkout.finish.button")));
		return new CheckOutCompleteService();
	}

}