package com.sedin.assess.sauce.services;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.sedin.assess.test.assertion.TestAssertions;
import com.sedin.assess.utils.JavaHelper;
import com.sedin.assess.utils.ReadProperties;

public class ProductListService extends ProjectSpecificService {

	public ProductListService addProductIntoTheCart(String pName) {
		int i = 0;
		List<WebElement> eles = getWebElements(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.productname.text"));
		for (WebElement ele : eles) {			
			if(ele.getText().trim().equals(pName)) {
				productName = ele.getText().trim();
				price = getWebElement(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.price.text")).getText();
				getWebElements(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.addtocart.button")).get(i).click();
				break;
			} else {
				i++;
			}
		}
		return this;		
	}

	public CartService clickOnTheCartIcon() {
		click(getWebElement(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.cart.icon")));
		return new CartService();
	}

	public ProductListService isProductAvailable(String pName) {		
		boolean isAvailable = false;
		List<WebElement> eles = getWebElements(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.productname.text"));
		for (int i = 0; i < eles.size(); i++) {
			if(eles.get(i).getText().trim().equals(pName)) {
				isAvailable = true;
				break;
			}			
		}
		TestAssertions.assertBoolean(isAvailable);
		return this;		
	}
	
	public ProductDetailService extractTheProductNameAndPrice() {
		List<WebElement> products = getWebElements(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.productname.text"));
		List<WebElement> prices = getWebElements(ReadProperties.readObjectRepositories("ProductListService", "sauce.demo.productlist.price.text"));
	    for (int i = 0; i < products.size(); i++) {
			productName = products.get(i).getText().trim();
			price = JavaHelper.extractString(prices.get(i).getText(), "[$]");
			map.put(productName, price);
		}
		return new ProductDetailService();
	}
	
	public ProductDetailService clickOnTheProduct(String pName) {
		click(getWebElement("linktext="+pName));
		return new ProductDetailService();
	}

}