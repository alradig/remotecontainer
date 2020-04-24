
Feature: Client provide access to his data to other client
  
  Clients should be able to provide access to their data to other clients.
  The data is composed of all the containers, journeys and client information except for the password.

  Scenario: Client provide access to another client
    Given a client is logged in
    And the client has registered journeys
    When the client provide access to another client
   	Then the other client should be able to access the client data