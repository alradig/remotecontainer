Feature: A Tracker for containers

Background: A container registered
	Given a client is logged in
	And the client registers a journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"
	Given the client logs out
	And there is an empty container
	When the logistic company registers the container for the journey
	
Scenario: Temperatur, air humidity, and atmopshere pressure are added
	Given that the logistic company is logged in 
	When internal temperatur of "50" degrees, air humidity of "40" percent, and atmopshere pressure of "30" Pa
	Then new measurements "50", "40", "30" are saved	
