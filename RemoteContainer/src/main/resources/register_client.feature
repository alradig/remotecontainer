Feature: Register client
  
	The system should allow logistic companies to register new clients.
	Basic information should be entered: (e.g., client name, address, reference person and email)
	and some other should be automatically generated (e.g., client id).

	Background:
		Given I have chosen to register a client

	Scenario: Successful register a client
		When I enter the following client information:
			| Client id | Name 					| Email 						| Address 									| Reference person|	Password	|
			|	1					| Brothers Farm	| old@email.com			| Kollegiebakken 9, Lyngby	| Jason						|	ghwq			|
		And I submit the form
		Then the client name should be 'Brothers Farm'
		And the client email should be 'old@email.com'
		And the client address should be 'Kollegiebakken 9, Lyngby'
		And the client reference person should be 'Jason'
		And the client password should be 'ghwq'
