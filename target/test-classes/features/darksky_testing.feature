@web @regression @darksky
Feature: Signup Message feature

  Background:



  @darksky-1
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Given I am on Darksky Home Page
     Then I verify current temp is not greater or less then temps from daily timeline

  @darksky-2
  Scenario: Verify timline is displayed in correct format
    Given I am on Darksky homepage
     Then I verify timeline is displayed with two hours incremented

  @darksky-3
  Scenario: Verify individual day temp timeline
    Given That I am Darksky HomePage
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly

  @darksky-4
  Scenario: Verify invalid signup error message
    Given I am on Darksky home page
    When I click on Register button
    Then I verify I am on Register page by asserting Register header

