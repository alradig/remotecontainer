
@tag
Feature: Logistic company updates journey information

  Scenario: Successful update of container journey
    Given Container has arrived in "Sweden"
    And Container end-destination is false
    When Update
    Then Current position is added to journey

 	Scenario: Container has successfully arrived at end destination
    Given Container has arrived in "Australia"
    And Container end-destination is true
    When Update
    Then Current position is added to journey
    And Journey is done
    
    
    


