Feature: Logistic Company logout
	
Scenario: Logistic Company logs out
	Given that the logistic company is logged in
	When the logistic company logs out
	Then the logistic company is not logged in