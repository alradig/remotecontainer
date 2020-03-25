@tag
Feature: A Tracker for containers

	Scenario: New internal temp
		Given Container end-destination is false
		And client "BananaExpress"
    And a trip origin "Denmark"
    And a trip desitnation "Australia"
		When New internal temp of "50"
		Then Internal temperature is saved

	Scenario: New air humidity
		Given Container end-destination is false
		And client "BananaExpress"
    And a trip origin "Denmark"
    And a trip desitnation "Australia"
		When New air humidity of "40"
		Then Air humidity is saved

	Scenario: New atmosph pressure
		Given Container end-destination is false
		And client "BananaExpress"
    And a trip origin "Denmark"
    And a trip desitnation "Australia"
		When New atmopsh pressure of "30"
		Then Atmosph pressure is saved
		
	Scenario: Journey is done
		Given Container end-destination is true
		Then Data reset