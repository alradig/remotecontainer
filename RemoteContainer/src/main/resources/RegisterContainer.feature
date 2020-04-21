Feature: Register container for Journey

Scenario: Register a container for a journey
	Given a client is logged in
	And the client registers a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
	And there is an empty container
	When the logistic company registers the container for the journey
	Then the journey is a registered journey for the client
	
#Scenario: Register more than one container to the same journey
#	Given a client is logged in
#	And the client registers a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
#	And the client adds the cargo "Bananas" to the same journey
#	And there is an empty container
#	When the logistic company registers the container for the journey
#	Then the journey is a registered journey for the client