@tag
Feature: Register client
  
	The system should allow logistic companies to register new clients.
	Basic information should be entered: (e.g., client name, address, reference person and email)
	and some other should be automatically generated (e.g., client id).

	Background:
		Given I have chosen to register a client
		And I am about to enter the client information
		 
 	@Test
  Scenario: Client name is not provided
  	When I do not enter the clients name
  	And I submit the form
  	Then the form should be redisplayed
  	And I should see a message advising me that the clients name is required
  	
  @Test
  Scenario: Client email is not provided
  	When I do not enter the clients email
  	And I submit the form
  	Then the form should be redisplayed
  	And I should see a message advising me that the clients email is required
  	
  @Test
  Scenario: Client address is not provided
  	When I submit the form
  	But I do not enter the clients address 
  	Then the form should be redisplayed
  	And I should see a message advising me that the clients address is missing
  	And I should be asked if I want to submit it anyway
  	
  	@Test
  Scenario: Client reference person is not provided
  	When I submit the form
  	But I do not enter the clients reference person 
  	Then the form should be redisplayed
  	And I should see a message advising me that the clients reference person is missing
  	And I should be asked if I want to submit it anyway
  	
  @Test
  Scenario: Client id is automatically generated
  	When I submit the form
  	And all the other details are correct
  	Then I should see a message telling me that the clients was successfully registered