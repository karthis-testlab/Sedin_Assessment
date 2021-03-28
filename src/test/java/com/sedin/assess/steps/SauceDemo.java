package com.sedin.assess.steps;

import java.util.List;

import com.sedin.assess.sauce.services.CheckOutService;
import com.sedin.assess.sauce.services.LoginService;
import com.sedin.assess.sauce.services.ProductDetailService;
import com.sedin.assess.sauce.services.ProductListService;
import com.sedin.assess.sauce.services.ProjectSpecificService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemo extends ProjectSpecificService {
	
	@Given("User want to purchase the sauce lab merchandise product on the offical cart site")
	public void user_want_to_purchase_the_sauce_lab_merchandise_product_on_the_offical_cart_site() {
		open(aut);	   
	}

	@Given("Regitered user able to login with valid user credentials {string} and {string}")
	public void regitered_user_able_to_login_with_valid_user_credentials_and(String uName, String pwd) {
		new LoginService().enterUserName(uName).enterPassword(pwd).clickOnTheLoginButton();
	}

	@When("User want to purchase {string} product and add to the cart")
	public void user_want_to_purchase_product_and_add_to_the_cart(String product) {
	    new ProductListService().addProductIntoTheCart(product).clickOnTheCartIcon().validateProductName().validateProductPrice().clickOnTheCheckoutButton();
	}

	@When("User confirm the added product and checkout the product to purchase with details")
	public void user_confirm_the_added_product_and_checkout_the_product_to_purchase_with_details(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> data = dataTable.asLists();
	    new CheckOutService().enterTheFirstName(data.get(0).get(0)).enterTheLastName(data.get(0).get(1)).enterZipCode(data.get(0).get(2)).clickOnTheCheckoutButton();
	}

	@Then("User able to validate and confirm the added product is correct one or not")
	public void user_able_to_validate_and_confirm_the_added_product_is_correct_one_or_not() {
	    new CheckOutService().validateProductName().validateProductPrice().clickOnTheFinishButton().validateOrderCompletence();
	}
	
	@Then("User able to the see {string} the product they wants")
	public void user_able_to_the_see_the_product_they_wants(String product) {
	   new ProductListService().isProductAvailable(product);
	}
	
	@When("User get price of the all products in the product listing page")
	public void user_get_price_of_the_all_products_in_the_product_listing_page() {
	    new ProductListService().extractTheProductNameAndPrice();
	}

	@Then("Validate the price with product listing with product individual page")
	public void validate_the_price_with_product_listing_with_product_individual_page() {
	    new ProductDetailService().validateTheProductPrice();
	}
	
	@When("Invalid user try to login into the site with following credentials {string} and {string}")
	public void invalid_user_try_to_login_into_the_site_with_following_credentials_and(String uName, String pwd) {
		new LoginService().enterUserName(uName).enterPassword(pwd).clickOnTheLoginButton();
	}
	
	@When("User should see proper error message and should not enter into product list page")
	public void user_should_see_proper_error_message_and_should_not_enter_into_product_list_page() {
	    new LoginService().validateTheInvalidUserCredentialsErrorMessage();
	}

}