Feature: Multi-Product Cart Checkout

  Scenario: Add multiple items to cart and proceed to checkout
    Given I launch the Flipkart application
    When I add products from excel "testdata.xlsx" sheet "Sheet1"
    And I go to the cart and proceed to checkout
    Then I should be presented with the login or checkout options