package com.sedin.assess.sauce.services;

import com.sedin.assess.test.assertion.TestAssertions;
import com.sedin.assess.utils.ReadProperties;

public class CheckOutCompleteService extends ProjectSpecificService {
	
	public CheckOutCompleteService validateOrderCompletence() {		
		TestAssertions.verifyTheExactText("THANK YOU FOR YOUR ORDER", getText(getWebElement(ReadProperties.readObjectRepositories("CheckOutCompleteService", "sauce.demo.checkout.complete.thankyou.text"))));
		return this;
	}

}