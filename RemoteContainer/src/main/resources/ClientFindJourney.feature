Feature: Client can search for a journey

Background: The client has a set of journeys
    Given that the client "BananaExpress" is logged in 
    And these journeys are in the system
        | Banana | Copenhagen | Sydney |
        | Tables | Beijing | New York |
        | Chairs | Moscow | Oslo | 
    And the client logs out 
    
Scenario: Searching for journey
    Given that the client "BananaExpress" is logged in 
    When the client search for "Chairs"
    Then the journey with cargo "Chairs", start destination "Moscow" and end destination "Oslo" is found

