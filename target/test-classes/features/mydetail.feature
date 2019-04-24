Feature: My  details pages



  @wip
  Scenario: room  information
    Given user on the log in page
    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    Then user should be able to quotos info fpr each room
    |ping pong    |the more the better      |
    |duke         | less is more           |
    |harvard      |the more the better      |
    |yale         |the more the better      |
    |berkeley     |less is more            |
    |stanford    |the more the better      |
    |princeton    |less is more             |


  Scenario: my  information
    Given user on the log in page
    And user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    When the user goes to the "my self" page

    Then the user should see their information:
      | name   | Ruthann Johnes      |
      | role   | student-team-leader |
      | team   | CodeHunters         |
      | batch  | #8                  |
      | campus | VA                  |
    Scenario Outline: my information data driven test <user_name>
      Given user on the log in page
      And user logs in using "<user_email>" and "<user_password>"
      When the user goes to the "my self" page
      Then the user should see their information:

        | name   | <user_name>       |
        | role   | <user_role>       |
        | team   | <user_team>       |
        | batch  | <user_batch>      |
        | campus | <user_campus>     |


      Examples:
        | user_email                    | user_password     | user_campus | user_name          | user_team            | user_role       | user_batch |
        | lruffli93@dailymail.co.uk     | menardnewbatt     | VA          | Menard Newbatt     | GuardiansofGalaxy    | team-leader     | #7         |
        | elaye8m@wikipedia.org         | tabordullingham   | VA          | Tabor Dullingham   | DevOps               | student         | #7         |
        | sweeklybh@spotify.com         | bartletcarlin     | IL          | Bartlet Carlin     | Cucumber             | student         | #8         |
#        | ucarlislebv@gizmodo.com       | herbyedwicke      | IL          | Herby Edwicke      | Swift               | student     | #8         |
#        | strayford84@e-recht24.de      | carlosmichie      | VA          | Carlos Michie      | Frostbite           | team-leader | #8         |
#        | jrowesby8h@google.co.uk       | aldridgegrimsdith | VA          | Aldridge Grimsdith | Rangers             | student     | #7         |
#        | mnewbatt8o@utexas.edu         | opalcave          | VA          | Opal Cave          | DevOps              | student     | #7         |
#        | teachervamikemarcus@gmail.com | mikemarcus        | VA          | Mike Marcus        | TeachersBand        | teacher     | #7         |