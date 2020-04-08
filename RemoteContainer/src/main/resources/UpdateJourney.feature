Feature: Logistic company updates journey information

  Scenario: Successful update of container journey
    Given date and local time
    And client name "BananaExpress"
    And end destination "Australia"
    And start destination "Denmark"
    When container has arrived in "Sweden"
    Then current position is added to journey
    And the journey is saved


 	Scenario: Container has successfully arrived at end destination
    Given date and local time
    And client name "BananaExpress"
    And end destination "Australia"
    And start destination "Denmark"
    When  container has arrived in "Sweden"
    When  container has arrived in "Russia"
    And  container has arrived in "Australia"
    Then current position is added to journey
  	And the journey is saved