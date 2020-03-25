@tag
Feature: A Tracker for containers

	Scenario: New internal temp
		Given Container end-destination is false
		And Register
		When New internal temp of "50"
		Then Internal temperature is saved

	Scenario: New air humidity
		Given Container end-destination is false
		And Register
		When New air humidity of "40"
		Then Air humidity is saved

	Scenario: New atmosph pressure
		Given Container end-destination is false
		And Register
		When New atmopsh pressure of "30"
		Then Atmosph pressure is saved
		
	Scenario: Journey is done
		Given Container end-destination is true
		And Register
		Then Internal temp is reset
		And Air humidity is reset
		And atmosph pressure is reset