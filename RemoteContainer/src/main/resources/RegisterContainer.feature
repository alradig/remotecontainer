Feature: Register container for Journey

Scenario: Register a container for a journey
	Given that the client "Hi" with ID "int" is logged in
	And there is a journey with port of origin country "Denmark", harbor "Copenhagen" and destination country "Australia" and "harbour" 
	And there is a container with content "Apples", of company "SuperFruit" 
	When the client registers the container for the journey 
	Then the container should be added to the journey

  #Scenario: Successfull registration 
    #Given client name "BananaExpress"
    #And start destination "Denmark"
    #And end destination "Australia"
    #And cargo "Banana"
    #When register
    #Then registration is true
#
#	Scenario: No end-destionation provided
    #Given client name "BananaExpress"
    #And start destination "Denmark"
    #And cargo "Banana"
    #And end destination is empty
    #When register
    #Then registration is false
    #
#Scenario: No original-destionation provided
    #Given client name "BananaExpress"
    #And end destination "Australia"
    #And cargo "Banana"
    #And start destination is empty
    #When register
    #Then registration is false
    #
#Scenario: No Content provided
    #Given client name "BananaExpress"
    #And start destination "Denmark"
    #And end destination "Australia"
    #And cargo is empty
    #When register
    #Then registration is false
    