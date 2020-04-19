Feature: A Tracker for containers

Background: A container registered
	Given a client is logged in
	And there is a journey with port of origin harbor "Copenhagen" and destination "harbour" 
	And there is a container with content "Apples"
	And the client logs out 
	
Scenario: Temperatur, air humidity, and atmopshere pressure are added
	Given that the logistic company is logged in 
	When internal temperatur of "50" degrees, air humidity of "40" percent, and atmopshere pressure of "30" Pa
	Then new measurements are saved
	
Scenario: One measurement not available
	Given that the logistic company is logged in 
	When internal temperatur of "50" degrees and air humidity of "40" percent
	Then new values are saved
	
