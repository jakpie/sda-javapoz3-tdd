Feature: WriteService

  Scenario: hello world
    Given I create new write service
    When i pass example name
    Then result is correct