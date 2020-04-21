Feature: Client logout
	
Scenario: Client logs out
	Given that a client is logged in
	When a client logs out
	Then a client is not logged in