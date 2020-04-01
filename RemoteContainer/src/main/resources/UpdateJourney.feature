Feature: Logistic company updates journey information

  Scenario: Successful update of container journey
    Given date and local time
    And end destination "Australia"
    When container has arrived in "Sweden"
    Then current position is added to journey

 	Scenario: Container has successfully arrived at end destination
    Given date and local time
		And end destination "Australia"
    When container has arrived in "Australia"
    Then current position is added to journey
  