@cart
Feature: Shopping Cart Page Feature

  Background: 
    Given user has already logged in to application
      | username                | password     |
      | rakesh.usmail@gmail.com | Password@123 |

  @norun
  Scenario: Shopping Cart Page
    Given I am on Shopping Cart page
    When I get the title of page
    Then I see the title as "Automation Exercise"

  
  Scenario: Shopping Cart Columns
    Given I am on Shopping Cart page
    Then I get Shopping Cart page section
      | Item        |
      | Description |
      | Price       |
      | Quantity    |
      | Total       |
    And Shopping Cart page section count should be 5
