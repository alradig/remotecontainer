
Feature: A Tracker for containers

	Scenario: New values
		Given New internal temp of "50"
		Given New air humidity of "40"
		Given New atmopshere pressure of "30"
		Then Values saved
		
	Scenario: Journey is done
		Given Container end-destination is true
		Then Data reset