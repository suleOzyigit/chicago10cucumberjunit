 @outline
Feature: Google searc functionality
  Scenario Outline: Testing google search
    Given user shold be on google page
    When user enters "<searcValue>" in the search
    Then user shoyld see "<searcValue>" on the page
    Examples: search values
    |searcValue|
    |cat       |