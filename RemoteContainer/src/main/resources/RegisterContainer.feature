	@tag
Feature: Register container for Journey

  Scenario: Successfull registration 
    Given client name "BananaExpress"
    And start destination "Denmark"
    And end destination "Australia"
    And cargo "Banana"
    When register
    Then registration is true

	Scenario: No end-destionation provided
    Given client name "BananaExpress"
    And start destination "Denmark"
    And cargo "Banana"
    And end destination is empty
    When register
    Then registration is false
    
Scenario: No original-destionation provided
    Given client name "BananaExpress"
    And trip desitnation "Australia"
    And company name "Banana"
    And trip origin is empty
    When register
    Then registration is false
    
Scenario: No Company provided
    Given trip origin "Denmark"
    And end destination "Australia"
    And cargo "Banana"
    And client name is empty
    When register
    Then registration is false
    
Scenario: No Content provided
    Given client name "BananaExpress"
    And start destination "Denmark"
    And end destination "Australia"
    And cargo is empty
    When register
    Then registration is false
    