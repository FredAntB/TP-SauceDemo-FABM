Feature: Checkout
  Background: User login into Sauce Demo
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  @run
  Scenario Outline: Verify that checkout isn't possible without Name or Lastname
    Given I click on the cart icon
    And I click on the checkout button
    And I fill checkout information with
      | <name>  | <lastname>  | <zipcode> |
    And I click on the continue button
    Then An error message is displayed
    Examples:
    | name      | lastname  | zipcode |
    |           | Viscarra  | 22222   |
    | Mauricio  |           | 22222   |