Feature: Create, update, delete students

@student
  Scenario: Add a student
    Given the user has access token as a teacher
    When the user creates a new student
    Then the new student should be created
    And the new student information should be in the database
    And the user should be able to login with the new student info


  Scenario: Exclude a student
    Given the user has access token as a teacher
    And there is a student available
    When student deleted using the exclude service
    Then the student should be deleted
    And the new student information should not be in the database
    And the user should not be able to login with the new student info
