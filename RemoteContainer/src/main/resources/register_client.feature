
Feature: Register client
  
	The system should allow logistic companies to register new clients.
	Basic information should be entered: (e.g., client name, address, reference person and email)
	and some other should be automatically generated (e.g., client id).
		

	Scenario: Successful register a client
		Given the administrator is logged in
		And There is a client with name "Brothers FarmBrothers Farm", email "old@email.comold@email.com", reference person "Jason", password "gwr" 
		And the client address is "Kollegiebakken" 9, "Lyngby"
		When the administrator registers the client 
		Then the client is registered in the system