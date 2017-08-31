Feature: Bank Account

  Scenario: Newly created user is visible in bank database
    Given I create new bank
    When I create new user
      And I add new user to bank
    Then User is present in bank database

  Scenario: I can create user and account, and they are present in bank database
    Given I create new bank
    When I create new user
      And I create new account
      And I add new user to bank
      And I add new user to account
      And I add account to bank
    Then User is present in bank database
      And Account is present in bank database
      And User is attached to account in bank database

  Scenario: I can list all accounts attached to given user
    Given I create new bank
    When I create new user with firstName Szymon and lastName Nowak and add it to bank
      And I create new user with firstName Anna and lastName Kowalska and add it to bank
      And I create new account for user 0 and add it to bank
      And I create new account for user 1 and add it to bank
      And I create new account for user 0 and add it to bank
    Then User with id 0 is present in bank database
      And User with id 0 has 2 accounts

  Scenario: I can deposit some money to account stored in bank
    Given I create new bank
    When I create new account
    And I add account to bank
    And I deposit 100 amount of money to account
    Then Account is present in bank database
    And Amount of money 100 is stored in account

  Scenario: I can deposit multiple to same account
    Given I create new bank
    When I create new account
    And I add account to bank
    And I deposit 150 amount of money to account
    And I deposit -250 amount of money to account
    And I deposit 300 amount of money to account
    Then Account is present in bank database
    And Amount of money 200 is stored in account

  Scenario: I can list sorted users by their balance
    Given I create new bank
    When I create new user with firstName Jan and lastName Kowalski and add it to bank
    And I create new user with firstName Anna and lastName Czerwinska and add it to bank
    And I create new user with firstName Tomek and lastName Rzepka and add it to bank
    And I create new account for user 0 and add it to bank
    And I create new account for user 1 and add it to bank
    And I create new account for user 2 and add it to bank
    And I deposit 300 to account with id 0
    And I deposit 100 to account with id 1
    And I deposit -1000 to account with id 2
    And I list sorted users by balance
    Then User with id 0 is on top of the sorted list