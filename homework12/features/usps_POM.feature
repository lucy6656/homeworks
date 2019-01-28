@usps
Feature: usps page object tests

  @usps1
  Scenario: Validate ZIP code page object
    Given I go to usps page object
    When I go to Lookup ZIP page object by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state page object
    Then I validate "94022" zip code exists in the result page object

  @usps2
  Scenario: Calculate price logic page object
    Given I go to usps page object
    When I go to Calculate Price page object
    And I select "United Kingdom of Great Britain and Northern Ireland" with "Postcard" shape And I define "2" quantity page object
    Then I calculate the price and validate cost is "$2.30" page object

  @usps3
  Scenario: Wrong store id does not match page object
    Given I go to usps page object
    When I go to Postal Store tab
    And I enter "12345" into store search page object
    Then I search and validate no products found page object