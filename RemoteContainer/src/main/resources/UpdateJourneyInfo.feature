
@tag
Feature: Logistic company updates journey information

  Scenario: Successful update of container journey
    Given container has arrived in "Sweden"
    And container end-destination is false
    When update
    Then current position is added to journey

 	Scenario: Container has successfully arrived at end destination
    Given container has arrived in "Australia"
    And container end-destination is true
    When update
    Then current position is added to journey
    And journey is done
    
    
    


