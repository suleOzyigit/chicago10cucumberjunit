@sm

Feature: Create students permission

  Scenario: Student should not be able to create
    Given the user has access token as a student
    When the user creates a new student
    Then the new student should not be created

  Scenario: teachers should be able to create
    Given the user has access token as a teacher
    When the user creates a new student
    Then the new student should be created


