Feature: Logistic company updates journey information

	Scenario: Update journey
		Given there is an existing journey and container
		And that the logistic company is logged in
		When the logistic company updates the journey location to "Oslo"
		Then the journey current position is updated with current location "Oslo"

#Background: A container and journey is registered
#	Given there is a client registered in the system
#	And the client registers a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
#	And there is an existing journey and container
#
#Scenario: Journey is updated
#	Given that the logistic company is logged in 
#	When the journey has arrived at "Oslo"
#	Then current position is updated with current location "Oslo"
	