Feature: Map page details


  Scenario: Light side rooms
    Given user on the log in page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then I should be able to see "ping pong" room

  Scenario: Light side all rooms
    Given user on the log in page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then the user should be able to see following conferance rooms
    |harvard    |
    |yale       |
    |princeton  |
    |stanford  |
    |duke       |
    |berkeley   |
    |ping pong  |

    #CMD+option+L===== pipe lari duzene koyuyor


  Scenario: team members test
    Given user on the log in page
    And user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    When the user goes to the "my team" page
    Then following team members should be displayed:
      | Archibald |
      | Leonard   |
      | Lorette   |
      | Durant    |