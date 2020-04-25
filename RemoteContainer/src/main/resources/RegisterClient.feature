Feature: Register client
  
	The system should allow logistic companies to register new clients.
	Basic information should be entered: (e.g., client name, address, reference person and email)
	and some other should be automatically generated (e.g., client id).

	Scenario: Successful register a client
		Given the logistic company is logged in
		And there is a client with name "Brothers Farm", email "old@email.comold@email.com", reference person "Jason"
		And the client address is "Kollegiebakken 9", "2800", "Lyngby"
		When the logistic company registers the client 
		Then the client is registered in the system
		
		Scenario: Register an already registered client
		Given there is a client registered in the system
		And the logistic company is logged in
		When the logistic company registers the client again
		Then the system gives the error message "The client is already registered"