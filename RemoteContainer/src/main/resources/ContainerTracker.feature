Feature: A Tracker for containers

Background: A container registered
	Given there is a client registered in the system
	And there is an existing journey with cargo "Apples", port of origin harbor "Copenhagen" and destination  "London"

Scenario: Temperatur, air humidity, and atmopshere pressure are added
	Given that the logistic company is logged in 
	When internal temperatur of "50" degrees, air humidity of "40" percent, and atmopshere pressure of "30" Pa
	Then new measurements "50", "40", "30" are saved	
