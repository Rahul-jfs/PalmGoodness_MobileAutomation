Feature:Validate Searched and Displayed Products are matching

  Scenario: Validating whether searched item and displayed items are same on plum app
    Given user opens application
    Then verify user is on the Plum Goodness homepage
    When user selects product category "fragrance"
    And user selects product type "orchid-you-not" from the drop down
    Then verify user is on selected product screen "OrchidYouNot"