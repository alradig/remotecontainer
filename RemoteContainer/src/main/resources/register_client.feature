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
				

#	@Test
#  Scenario: Client name is not provided
#  	When I do not enter the clients name
#  	And I submit the form
#  	Then the form should be redisplayed
#  	And I should see a message advising me that the clients name is required
  	
#  @Test
#  Scenario: Client email is not provided
#  	When I do not enter the clients email
#  	Then the form should be redisplayed
#  	And I submit the form
#  	And I should see a message advising me that the clients email is required
#  	
#  @Test
#  Scenario: Client address is not provided
#  	When I submit the form
#  	But I do not enter the clients address 
#  	Then the form should be redisplayed
#  	And I should see a message advising me that the clients address is missing
#  	And I should be asked if I want to submit it anyway
#  	
#  Scenario: Client reference person is not provided
#  	@Test
#  	When I submit the form
#  	But I do not enter the clients reference person 
#  	Then the form should be redisplayed
#  	And I should see a message advising me that the clients reference person is missing
#  	And I should be asked if I want to submit it anyway
#  	
#  @Test
#  Scenario: Client id is automatically generated
#  	When I submit the form
#  	And all the client details are valid
#  	Then I should see a message telling me that the clients was successfully register

