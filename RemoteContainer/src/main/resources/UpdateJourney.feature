Feature: Logistic company updates journey information

Background: A container and journey is registered
	Given there is a client registered in the system
	And there is an existing journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"

Scenario: Journey is updated
	Given that the logistic company is logged in 
	When the journey has arrived at "Oslo"
	Then current position is updated	