Feature: Multi-Product Cart Checkout

  Scenario: Add multiple items to cart and proceed to checkout
    Given I launch the Flipkart application
    When I add the following products to the cart:
      | Nothing Phone 2a |
      | Nothing Phone 3a |
      | Nikon D850       |
    And I go to the cart and proceed to checkout
    Then I should be presented with the login or checkout options