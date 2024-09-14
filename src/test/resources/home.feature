Feature: Home page
  Background: User login into Sauce Demo
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    @run
    Scenario Outline: Sort products in Sauce Demo's home page by price
      Given I sort the home page products by "<drop_down_option>"
      Then The products should be sorted by "<sorted_by>" in "<sorting_order>" order
      Examples:
      | drop_down_option    | sorted_by | sorting_order |
      | Name (Z to A)       | name      | descending    |
      | Price (high to low) | price     | descending    |
      | Price (low to high) | price     | ascending     |