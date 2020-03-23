@web @hotel @regression

Feature: Hotels features

  Background:

  @hotel-1
  Scenario Outline: Verify user can only view the result by selected property class
     Given I am on the default locations search result screen
      When I select property class <starValue>
      Then I verify system displays only <starValue> hotels on search result
    Examples:
      |starValue|
      | 5-star|
      | 4-star|
      | 3-star|

  @hotel-2
  Scenario: List of all of hotel within 10 miles radius of airport or downtown
     Given I am on default location search result screen
      Then I verify system displays all hotels within 10 miles radius of airport
       And I verify Hilton Hotel is within 10 miles radius

  @hotel-3
  Scenario: Verify todays deal price value
     Given I am on default locations search result screen
      Then I verify todays deal is less than $200

  @hotel-4
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
     Then I select <select_rooms> from room dropdown
      And I verify <number_of_room_dropdown> is displayed
   Examples:
   |select_rooms   | number_of_room_dropdown|
     #| 2            | 2                    |
     #| 3            | 3                    |
      | 4            | 4                    |
   # | 5            | 5|
  #  | 6            | 6|
  #  | 7            | 7|
   # | 8            | 8|
    #| 9+           | 0|
