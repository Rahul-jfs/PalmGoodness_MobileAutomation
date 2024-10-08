Feature: Validate Cart Value In Plum Goodness Application

  Scenario: User searches for products, adds multiple products to the cart, and verifies the cart value in app
    Given user opens application
    Then verify user is on the Plum Goodness homepage
    When the user enters "search.value1" into the search bar
    Then verify user is on searched "search.value1" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    And clicks on the shopping cart icon
    And navigates next to search next product
    When the user enters "search.value2" into the search bar
    Then verify user is on searched "search.value2" product page
    When user clicks on a product from the search results
    Then user should be redirected to the product details page
    When user clicks the Add to Cart button
    When clicks on the shopping cart icon
    Then verify the total cart value is correct based on product prices