Feature: Validate Add To Cart Button In Plum Goodness Website

  Background:
    Given user opens application
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value1" into the search bar
    Then verify user is on searched "search.value1" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon

  Scenario: User searches for a product and adds it to the cart in application
    Then verify item is added into cart and should displays "(1 item)"

  Scenario: User removes an item from the cart and verify count
    And navigates next to search next product
    When the user enters "search.value2" into the search bar
    Then verify user is on searched "search.value2" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    And user views the cart contents
    When user clicks on remove button next to an item
    Then the item "search.value1" should be removed from the cart
    And the cart should display the updated cart count