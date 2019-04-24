@login
Feature: Home page
  As a user When I enter correct login format I should be able to login

  Background: user on the log in page
    Given user on the log in page

  @leader

  Scenario: login as a team lead
   # Given user on the log in page
    When user logs in as a team lead
    Then Home page should be display
   # And title should be correct
@member
  Scenario: login as a team member
   # Given user on the log in page
    When user logs in as a team member
    Then Home page should be display
   # And title should be correct
@teacher
  Scenario: login as a teacher
   # Given user on the log in page
    When user logs in as a teacher
    Then Home page should be display
  #  And title should be correct
  @dif
Scenario Outline: login as a different memeber
  When user logs in as a <type>
    Then Home page should be display
  Examples:
  |type        |
  |team lead   |
  |team member |
  |teacher     |