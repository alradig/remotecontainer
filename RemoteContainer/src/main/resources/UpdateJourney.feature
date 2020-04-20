Feature: Logistic company updates journey information

Background: A container is registered
	Given a client is logged in
	And the client registers a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
	And the client logs out
	And there is an empty container
	And the logistic company registers the container for the journey
	
Scenario: Journey is updated
	Given that the logistic company is logged in 
	When the journey has arrived at "Oslo"
	Then current position is updated	