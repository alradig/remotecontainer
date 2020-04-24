
Feature: Client view his/her own information
  
  Clients see their containers and their corresponding data but no other clients.

  Scenario: Client view all containers registered to their journeys
    Given a client is logged in
    And the client has registered journeys
    When the client looks for all his/her containers
    Then all containers registered for the client journeys is given
