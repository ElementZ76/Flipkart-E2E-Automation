Feature: Multi-Product Cart Checkout

  Scenario: Add multiple items to cart and proceed to checkout
    Given I launch the Flipkart application
    When I add the following products to the cart:
      | Nothing Phone 2a |
      | Nikon D850       |
      | iPhone 15 		 |
    And I go to the cart page
    Then I should see the "Place Order" button