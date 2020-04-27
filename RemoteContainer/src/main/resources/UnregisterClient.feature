Feature: Unregister client
  
	The system should allow logistic companies to unregister clients.
	Basic information should be entered: (client name, email)

	Scenario: Successfully unregister a client
		Given the logistic company is logged in
		And the client has info "Brothers Farm", email "old@email.comold@email.com", reference person "Jason"
		And the client has password "clientclient"
		When the client is found
		Then the client is unregistered from the system
		
		Scenario: Failure to unregister a client
		Given the logistic company is logged in
		And the client has info "Brothers Farm", email "old@email.comold@email.com", reference person "Jason"
		And the client has password "testing"
		When the client is not found
		Then the system sends the error "The client is not registered or error in the information provided"