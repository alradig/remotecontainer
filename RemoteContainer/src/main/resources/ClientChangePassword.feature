Feature: Client can change password

	Clients should be able to change their password as it is provided by the logistic company at registration.
	
Scenario: Succesful change of password
	Given that a client is logged in
	When the client enters the current password "clientclient" and new password "client"
	Then the new password "client" is assigned to the client
	
