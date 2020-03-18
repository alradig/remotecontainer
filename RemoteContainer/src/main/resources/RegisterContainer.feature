
@tag
Feature: Register container for Journey

  Scenario: Successfull registration 
    Given client "BananaExpress"
    And a trip origin "Denmark"
    And a trip desitnation "Australia"
    And a content "Banana"
    When Register
    Then Client gets assigned an empty container

	Scenario: No end-destionation provided
    Given client "BananaExpress"
    And a trip origin "Denmark"
    And a content "Banana"
    When Register
    Then unable to register container 
    
Scenario: No original-destionation provided
    Given client "BananaExpress"
    And a trip desitnation "Australia"
    And a company name "Banana"
    When Register
    Then unable to register container 
    
Scenario: No Company provided
    Given a trip origin "Denmark"
    And a trip desitnation "Australia"
    And a conent "Banana"
    When Register
    Then unable to register container 
    
Scenario: No Content provided
    Given client "BananaExpress"
    And a trip origin "Denmark"
    And a trip desitnation "Australia"
    When Register
    Then unable to register container 

    
    