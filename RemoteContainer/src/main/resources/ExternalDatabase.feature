
Feature: External database
  
  The external database ensures that information is not lost
  when the software is closed and provides all the saved information
  to the software when it is reopened.

  Scenario: Save new client objects in the external database
  
  	Every client, journey and container object needs to be saved in the external
  	database when they are created
  
    Given I register the client
    | Client id | Name 					| Email 							| Address 										| Reference person|	Password	|
		|	765342		| Paper Inc.		| paperinc@email.com	| Street name 139, Copenhagen	| Jason						|	ghwq			|
    Then the client information should be in the external database