Feature: Logistic Company login
	
Scenario: Company can login
	Given the company is not logged in
	And the password is "logisticCompany123"
	Then the company login succeeds
	And the company is logged in
	
Scenario: Company has the wrong password
	Given the company is not logged in
	And the password is "wrong password"
	Then the company login fails
	And the company is not logged in
