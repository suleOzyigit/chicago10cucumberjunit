@googleParam
Feature: Google searc functionality
  Scenario: Testing google search
    Given user shold be on google page
    When user enters "flowers" in the search
    Then user shoyld see "flowers" on the page