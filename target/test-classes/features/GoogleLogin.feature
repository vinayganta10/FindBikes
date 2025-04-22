Feature: Google Account Login Validation

  Scenario: Invalid Email Handling
    Given the user navigates to the Zigwheels login options
    And the user selects the "Sign in with Google" option
    When the user enters an invalid email format
    Then the user should observe a "Enter a valid email or phone number" warning message

  Scenario: Non-Existent Email Handling
    Given the user navigates to the Zigwheels login options
    And the user selects the "Sign in with Google" option
    When the user enters a non-existent Google Account email
    Then the user should observe a "Couldn’t find your Google Account" warning message

  Scenario: Browser Security Warning
    Given the user navigates to the Zigwheels login options
    And the user selects the "Sign in with Google" option
    When the user enters a valid Google Account email
    Then the user should observe a "This browser or app may not be secure. Learn more" warning message