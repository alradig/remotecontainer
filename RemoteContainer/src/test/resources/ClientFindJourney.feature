
@tag
Feature: Client can view container journey

	 Scenario: Successful finding journey
    Given Client with journey of "Banana"
    And A start destination "Denmark"
    And A end destination "Australia"
    And the journey registered as true
    When Searching for journey
    Then Journey is displayed

 	 Scenario: No journey registered
    Given Client with journey of "Banana"
    And A start destination "Denmark"
    And A end destination "Australia"
    And the journey registered as false
    When Searching for journey
    Then system displays that journey is not registered
    
    

 