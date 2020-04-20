Feature: Client login
	
Scenario: Client can login
	Given a client is not logged in
	And the password is "client123"
	Then a client login succeeds
	And a client is logged in
	
Scenario: Client has the wrong password
	Given a client is not logged in
	And the password is "wrong password"
	Then a client login fails
	And a client is not logged in
