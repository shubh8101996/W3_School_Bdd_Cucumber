Feature: User Login
  As a user
  In order to access my learning dashboard
  I want to be able to log in to the website

  Background:
    Given I am on the login page

  Scenario: Valid login credentials
    When I enter valid username "shubhamshedge810@gmail.com" and password "AdminShubham@123"
    And I click on the login button
    Then I should be redirected to my learning dashboard

  Scenario: Invalid login credentials
    When I enter invalid username "shubhamshed@gfmail.com" and password "122ddsds"
    And I click on the login button
    Then I should see an error message indicating invalid credentials

  Scenario: Empty login fields
    When I leave the username and password fields empty
    And I click on the login button
    Then I should see an error message indicating required fields

  Scenario: Forgot password
    When I click on the "Forgot Password?" link
    Then I should be redirected to the password recovery page
  
  @run
  Scenario Outline: Login with different credentials
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    Then I should <outcome>

    Examples:
      | username                   | password          | outcome                           |
      | shubhamshedge810@gmail.com | AdminShubham@123  | be redirected to my learning dashboard |
      | shubhamshed@gfmail.com     | 122ddsds          | see an error message indicating invalid credentials |
      | ssnansajnhed@gfmail.com    | 2328hjshd         | see an error message indicating invalid credentials |
