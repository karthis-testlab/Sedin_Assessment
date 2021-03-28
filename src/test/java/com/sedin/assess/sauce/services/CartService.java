package com.sedin.assess.sauce.services;

import com.sedin.assess.test.assertion.TestAssertions;
import com.sedin.assess.utils.ReadProperties;

public class CartService extends ProjectSpecificService {
	
	public CartService validateProductName() {	
        TestAssertions.verifyTheExactText(productName, getText(getWebElement(ReadProperties.readObjectRepositories("CartService", "sauce.demo.cart.productname.text"))));
		return this;
	}

	public CartService validateProductPrice() {		
		TestAssertions.verifyTheContainsText(price, getText(getWebElement(ReadProperties.readObjectRepositories("CartService", "sauce.demo.cart.productprice.text"))));
		return this;
	}
	
	public CheckOutService clickOnTheCheckoutButton() {
		click(getWebElement(ReadProperties.readObjectRepositories("CartService", "sauce.demo.cart.checkout.button")));
		return new CheckOutService();
	}

}