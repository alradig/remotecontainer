Feature: Client can view container journey

	 Scenario: Successful finding journey
    Given client with the cargo "Banana"
    And start destination "Denmark"
    And end destination "Australia"
    And journey registered as true
    And information is saved
    When retrieve journey information
    Then all related journeys are displayed

 	 Scenario: No journey registered
    Given client with the cargo "Banana"
    And start destination "Denmark"
    And end destination "Australia"
    And journey registered as false
    When searching for the journey
    Then system displays that journey is not registered
