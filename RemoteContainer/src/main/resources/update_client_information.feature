#Feature: Update Client Information
#
#A logistic company needs to be able to update their clients information
#such as address, phone number, email etc.
#
#Background:
#		Given the client:
#			| Client id | Name 					| Email 						| Address 									| Reference person|	Password	|
#			|	1					| Brothers Farm	| old@email.com			| Kollegiebakken 9, Lyngby	| Jason						|	ghwq			|
#		And I have chosen to update the client information
#
#Scenario Outline: Update client information successful
    #Given I enter the new client <Information> as <New Value>
    #And I submit the form
    #Then the client <Information> should be <Updated Value>
    #And I should see <Outcome>
    #
#Examples: Success: correct information input
#	|	Information				|	New Value 											|	Updated Value										|	Outcome						|
#	|	name							|	'Family Farm'										| 'Family Farm'										|	a success message	|
#	|	email							|	'new@email.com'									|	'new@email.com'									|	a success message	|
#	|	address						|	'Tuborg Havnepark 28, Hellerup'	|	'Tuborg Havnepark 28, Hellerup'	|	a success message	|
#	| reference person	| 'Alfred'												|	'Alfred'												| a success message	|
#	
#Examples: Error: empty information input
#	In this cases the client information is not update and remains as the old one.
#
#	|	Information				|	New Value	|	Updated Value							|	Outcome						|
#	|	name							|	''				| 'Brothers Farm'						|	an error message	|
#	|	email							|	''				|	'old@email.com'				|	an error message	|
#	|	address						|	''				|	'Kollegiebakken 9, Lyngby'|	an error message	|
#	| reference person	| ''				|	'Jason'										| an error message	|