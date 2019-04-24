Feature: login Functionality

@login

  Scenario: teacher login

    Given user on the log in page
    When user logs in using "teacherva5@gmail.com" and "maxpayne"
    Then Home page should be display
    And the title should be "my aplication title"
    And there should be 4 option

  Scenario: team leader login
    Given user on the log in page
    When user logs in using "teacherva5@gmail.com" and "maxpayne"
    Then Home page should be display
    And the title should be "my aplication title"
   # And there should be 4 option
