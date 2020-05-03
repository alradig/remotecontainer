
Feature: Unregister Client N

	Scenario: Unregister a client that is in the system
	  Given the logistic company is logged in
		And there is a client registered in the system
	  When the logistic company unregister the client
		Then the client is removed from the system
		
	Scenario: Unsuccessful unregistration of client with ongoing journey
		Given Client has ongoing journey
		When the logistic company unregister the client
		Then the system sends the error message "Can not unregister a client when a journey is on going"
	