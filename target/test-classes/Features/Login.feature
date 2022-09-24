#this automation script created by shady ahmed
@SmokeScnario
Feature: Feature to test login functionality to swag labs web application

  @SmokeTest
  Scenario: Check if login is successfully with valid Credentials
    Given   user is in login page
    When    user add valid username and password
    And     click login button
    Then    user navigate to home page

  @SmokeTest
  Scenario: Check Login is successfully with invalid Credentials
    Given           user is in login page
    When            user add invalid username and password
      | standard_user1   | secret_sauce |
    And             click login button
    Then            user will not navigate to home page