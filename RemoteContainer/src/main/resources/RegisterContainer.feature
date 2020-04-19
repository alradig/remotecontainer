Feature: Register container for Journey

Scenario: Register a container for a journey
#	Given a client is logged in
	And there is a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
#	And there is a container with content "Apples"
	And there is an empty container
	When the client registers the container for the journey
	Then the container is a registered container for the journey
	
Scenario: Register a container for a journey that already exists
#	Given a client is logged in
#	And there is a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
#	And there is an empty container
#	When the client registers the container for the journey
#	Then the container is a registered container for the journey