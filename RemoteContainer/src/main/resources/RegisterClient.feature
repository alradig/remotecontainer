
@tag
Feature: logostic company register page should have verification on all fields.
  
	The system should allow logistic companies to register new clients.
	Basic information should be entered: (e.g., client name, address, reference person and email)
	and some other should be automatically generated (e.g., client id).

	Background: We are on the homepage
		Given I am on the register page
#		When  I click on "sign in link" on the "Home" page
    #And   I click on "register" on the "Sign In" page
    #And   I enter "test@test.com" into fields on the page
  #
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
