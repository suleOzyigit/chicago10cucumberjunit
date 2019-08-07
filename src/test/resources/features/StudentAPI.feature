Feature: Single student API automation
  @singlestudent
  Scenario: Student Atribute validation
    When user hits single student API with "http://cybertekchicago.com/student/88"
    Then user test for required attribitues