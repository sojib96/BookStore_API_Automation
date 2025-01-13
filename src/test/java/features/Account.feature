Feature: Account Module
  As a user,
  I want to create an account,
  authenticate so that I can fully manage my account,
  authorize to retrieve my data and information securely,
  and delete my account when no longer needed.

  Scenario: User Account Management
    Given the user provides valid details to create a new account
    Then the account should be successfully created with a non-null userId
    And the status code should be 201

    When the user submits their details to generate an authentication key
    Then the response status should be "Success"
    And the status code should be 200

    When the user includes the authentication key in the request body for authorization
    Then the user should receive a response body of "true"
    And the status code should be 200

    When the user submits the unique userId to retrieve account details
    Then the system should return the user's complete information containing same userId and userName
    And the status code should be 200

    When the user provides the unique userId to delete the account
    Then the status code should be 204
