@login
Feature: Logging in into the app
  As a customer
  I am allowed to login into the app with correct password
  I am not allowed to login into the app with wrong password
  So that only authenticated users ca access the app

  @positive
  Scenario Outline: Log in into the app with correct passcode
    Given I have the <IssuerApp> configured on the Android device
    When I launch the application
    Then Login screen is displayed
    When I enter the valid passcode <PassCode> into the app
    Then The app is "logging in" screen is displayed
    And I am logged in into the app
  Examples:
    | IssuerApp | PassCode |
    | Some App | 14789    |

  @negative
  Scenario Outline: Log in into the app with incorrect passcode
    Given I have the <IssuerApp> configured on the Android device
    When I launch the application
    Then Login screen is displayed
    When I enter the invalid passcode <PassCode> into the app
    Then The "Invalid Details" screen is displayed
    And the OK button is enabled
    When I press the OK button
    Then I am presented with the login screen
  Examples:
    | IssuerApp | PassCode  |
    | Some App  | 123456789 |

