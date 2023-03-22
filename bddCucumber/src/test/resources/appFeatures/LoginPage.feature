@login
Feature: Some feature

  Background: Login Page
    Given I am on login page

  @smoke
  Scenario: Page Title
    When I get the title of page
    Then I see the title as "Automation Exercise"

  @smoke @norun
  Scenario: Login/SignUp Link
    Then I see the Login or SignUp Link

  @regression
  Scenario: Invalid Login
    Given I click on Login or SignUp Link
    When I enter username as "someone@something.com"
    And I enter password as "someone@something"
    And I click on Login button
    Then I see message "Your email or password is incorrect!!"
