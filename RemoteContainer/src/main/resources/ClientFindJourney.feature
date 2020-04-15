[10.51] Ida Engholm Villumsen
    
Feature: Client can search for a journey


Background: The client has a set of journeys
    Given that the logistic company is not logged in 
    And these journeys are in the system
        | Banana | Copenhagen | Sydney |
        | Tables | Beijing | New York |
        | Chairs | Moscow | Oslo | 
    And the logistic company logs out 
    
Scenario: Searching for journey
    Given that the logistic company is logged in 
    When the client search for "Chairs"
    Then the journey with start destination "Moscow" and end destination "Oslo" is found

