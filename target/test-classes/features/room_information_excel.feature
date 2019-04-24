Feature: room information functionality


  Scenario: Room details
    Given user on the log in page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then correct room information should be displayed for light side
#    And room information should be displayed as given in "file_path" "sheetname"


#  Scenario: room information
#    Given user on the log in page
#    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
#    Then user should be able to quotos info fpr each room
#      | ping pong | the more the better |
#      | harvard   | the more the better |
#      | yale      | the more the better |
#      | stanford  | the more the better |
#      | princeton | less is more        |
#      | duke      | less is more        |
#      | berkeley  | less is more        |
#
  @ant
  Scenario Outline: my information data driven test <user_name>
    Given user on the log in page
    And user logs in usingDemo User "<user_email>" and "<user_password>"
    #When the user goes to the "my self" page
    When  my self page should display personal information for that user



    Examples:
      | user_email                    | user_password     | user_campus | user_name          | user_team            | user_role       | user_batch |
      | lruffli93@dailymail.co.uk     | menardnewbatt     | VA          | Menard Newbatt     | GuardiansofGalaxy    | team-leader     | #7         |
      | elaye8m@wikipedia.org         | tabordullingham   | VA          | Tabor Dullingham   | DevOps               | student         | #7         |
     #| sweeklybh@spotify.com         | bartletcarlin     | IL          | Bartlet Carlin     | Cucumber             | student         | #8         |
#        | ucarlislebv@gizmodo.com       | herbyedwicke      | IL          | Herby Edwicke      | Swift               | student     | #8         |
