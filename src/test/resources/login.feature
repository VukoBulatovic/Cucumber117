Feature: Login

  Scenario: User can log in
    Given User is on login page
    When User inputs valid username "tomsmith"
    And User inputs valid password "SuperSecretPassword!"
    And User clicks on Login button
    Then User is logged in

    Scenario Outline: User cannot log in with invalid credentials
      Given User is on login page
      When User inputs valid username <username>
      And User inputs valid password <password>
      And User clicks on Login button
      Then User is not logged in
      Examples:
        | username | password        |
        | "user1"  | "somepassword1" |
        | "user2"  | "somepassword2" |
        | "user3"  | "somepassword3" |


