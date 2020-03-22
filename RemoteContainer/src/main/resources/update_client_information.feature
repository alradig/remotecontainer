@tag
Feature: Update Client Information

  A logistic company needs to be able to update their clients information
  such as my address, phone number, email etc.

	Background:
		Given I have chosen to update a client information
		And I am about to enter the client new information

  @tag1
  Scenario Outline: Update client name
    Given the client <Information> is <Current Value>
    When I enter the new <Information> <New Value>
    And I submit the form
    Then the client <Information> should be <New Value>
    
Examples:
	|	Information	|	Current Value				|	New Value 			|
	|	name				|	'Brothers Farm'			|	'Family Farm'		|
	|	email				|	'current@email.com'	|	'new@email.com'	|