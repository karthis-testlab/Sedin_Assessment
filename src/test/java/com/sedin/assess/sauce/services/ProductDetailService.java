package com.sedin.assess.sauce.services;

import java.util.Map.Entry;

import com.sedin.assess.test.assertion.TestAssertions;
import com.sedin.assess.utils.ReadProperties;

public class ProductDetailService extends ProjectSpecificService {
	
	public ProductDetailService validateTheProductPrice() {
		for (Entry<String, String> entry : map.entrySet()) {
			String price = new ProductListService().clickOnTheProduct(entry.getKey()).extractPrice();
			TestAssertions.assertTheContainsText(entry.getValue(), price);
			clickOnTheBackButton();
		}
		return this;
	}	
	
	public String extractPrice() {
		return getText(getWebElement(ReadProperties.readObjectRepositories("ProductDetailService", "sauce.demo.productdetail.price.text")));
	}
	
	public ProductListService clickOnTheBackButton() {
		click(getWebElement(ReadProperties.readObjectRepositories("ProductDetailService", "sauce.demo.productdetail.back.button")));
		return new ProductListService();
	}

}