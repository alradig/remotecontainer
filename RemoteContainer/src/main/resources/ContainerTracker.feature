Feature: A Tracker for containers

	Scenario: New values
		Given New internal temp of "50"
		And New air humidity of "40"
		And New atmopshere pressure of "30"
		When Container end-destination is false
		Then Values saved
		
	Scenario: Journey is done
		Given New internal temp of "50"
		And New air humidity of "40"
		And New atmopshere pressure of "30"
		When Container end-destination is true
		Then Data reset