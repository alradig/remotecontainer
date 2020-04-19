Feature: Logistic company updates journey information

Background: A container registered
	Given a client is logged in
	And the client registers a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
	And there is an empty container
	And the logistic company registers the container for the journey
	And the client logs out
