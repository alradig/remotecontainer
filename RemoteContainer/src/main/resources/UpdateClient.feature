Feature: Update Client Information

A logistic company needs to be able to update their clients information
such as address, email etc.

	Scenario: The logistic company updates the client information;
		Given there is a client registered in the system
		And the logistic company is logged in
		When the logistic company updates the client reference person to "Gady Laga"
		Then the client information should be updated