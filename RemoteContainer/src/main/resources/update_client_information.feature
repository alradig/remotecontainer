@tag
Feature: Update Client Information

  A logistic company needs to be able to update their clients information
  such as my address, phone number, email etc.

	Background:
		Given the client:
			| Client id | Name 						| Email 							| Address 										| Reference person	|	Password	|
			|	1					| 'Brothers Farm'	| 'current@email.com'	| 'Kollegiebakken 9, Lyngby'	| 'Jason'						|	'ghwq'		|
		And I am about to enter the client new information

  @tag1
  Scenario Outline: Update client information successful
    Given I enter the new <Information> as <New Value>
    And I submit the form
    Then the client <Information> should be <New Value>
    
Examples:
	|	Information				|	New Value 											|
	|	name							|	'Family Farm'										|
	|	email							|	'new@email.com'									|
	|	address						|	'Tuborg Havnepark 28, Hellerup'	|
	| Reference person	| 'Alfred'												|