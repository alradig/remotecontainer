Feature: Logistic Company logout
	
Scenario: Company logs out
	Given that the company is logged in
	When the company logs out
	Then the company is not logged in