Feature: Logistic Company login
	
Scenario: Logistic Company can login
	Given the logistic company is not logged in
	And the password is "logisticCompany123"
	Then the logistic company login succeeds
	And the logistic company is logged in
	
Scenario: Logistic Company has the wrong password
	Given the logistic company is not logged in
	And the password is "wrong password"
	Then the logistic company login fails
	And the logistic company is not logged in
