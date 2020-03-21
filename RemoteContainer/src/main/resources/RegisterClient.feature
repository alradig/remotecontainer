@tag
Feature: Register a client
  
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
  Scenario Outline: All of the fields should display an error 
  									when not populated on form submission
  									
  	When   I enter "test@test.com" into fields on the page						
    And    I leave the "<field>" field on the register page empty
    And    I click on "submit" on the "Create Account" page
    Then   the "<error>" on the "Create Account" page should be "visible"

    Examples: 
      | field            |  error                          |
      | name             |  missing_name_error             |
      | email            |  missing_email_error            |
      | password         |  missing_password_error         |
      | confirm_password |  missing_confirm_password_error |
