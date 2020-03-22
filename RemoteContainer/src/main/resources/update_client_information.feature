@tag
Feature: Update Client Information

  A logistic company needs to be able to update their clients information
  such as my address, phone number, email etc.

	Background:
		Given I have chosen to update a client information
		And I am about to enter the client new information

  @tag1
  Scenario: Update client name
    Given the client name is 'Brothers Farm' 
    When I enter the new name 'Family Farm'
    And I submit the form
    Then the client name should be 'Family farm'
    And I should see a message telling me that the clients name was successfully updated!
