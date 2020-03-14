@web @regression @darksky
Feature: Darksky temperature

  Background:

  @darksky-4
  Scenario: Verify invalid signup error message
     Given I am on Darksky home page
      When I click on Register button
      Then I verify I am on Register page by asserting Register header