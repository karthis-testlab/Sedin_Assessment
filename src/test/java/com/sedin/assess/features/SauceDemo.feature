Feature: Sauce Demo is site used to cart sauce lab merchandise product

  Background: User landing into sauce lab merchandise site
    Given User want to purchase the sauce lab merchandise product on the offical cart site

  Scenario: User able to the checkout the product which added into the cart
    Given Regitered user able to login with valid user credentials "standard_user" and "secret_sauce"
    When User want to purchase "Sauce Labs Backpack" product and add to the cart
    And User confirm the added product and checkout the product to purchase with details
      | TestFirstName | TestLastName | 626117 |
    Then User able to validate and confirm the added product is correct one or not

  Scenario: User able to find the product which they want
    When Regitered user able to login with valid user credentials "standard_user" and "secret_sauce"
    Then User able to the see "Sauce Labs Bolt T-Shirt" the product they wants
  
  Scenario: User can compare the all product price in the product detial page
    When Regitered user able to login with valid user credentials "standard_user" and "secret_sauce"
    And User get price of the all products in the product listing page
    Then Validate the price with product listing with product individual page

  Scenario: Invalid user does not have access to enter into product list site they should restrict at first level itself
    When Invalid user try to login into the site with following credentials "standard_user1" and "secret_sauce2"
    But User should see proper error message and should not enter into product list page