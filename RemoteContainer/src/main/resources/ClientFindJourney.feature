Feature: Client can search for a journey

Background: The client has a set of journeys
    Given a client is logged in
    And these journeys are in the system
        | Banana | Copenhagen | Sydney |
        | Banana | Sydney | Copenhagen |
        | Tables | Beijing | New York |
        | Chairs | Moscow | Oslo | 
    And a client logs out 
    
Scenario: Searching for journey with unique cargo
    Given a client is logged in
    When the client search for "Chairs"
    Then the journey with cargo "Chairs", start destination "Moscow" and end destination "Oslo" is found

Scenario: No journeys match the search
	Given a client is logged in
	When the client search for "Books"
	Then no journeys are found

Scenario: Searching for journey with common cargo
    Given a client is logged in
    When the client search for "Banana"
    Then journeys with start destination "Copenhagen" and "Sydney" are found
