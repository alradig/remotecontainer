Feature: Logistic company can search for a client

Background: The logistic company has a set of clients
	Given that the logistic company is logged in 
	And these clients are in the system
		| BananaExpress |  bob@mail.com  | Bob |
		| HappyPrint | jiayi@mail.com | Jiayi |
		| CakeDay | ida@mail.com | Ida |
	And the logistic company logs out
	
Scenario: Searching for client
	Given that the logistic company is logged in 
	When the logistic company search for "bob@mail.com"
	Then the client "BananaExpress" is found
	
Scenario: No clients match the search
	Given that the logistic company is logged in 
	When the logistic company search for "hej@mail.com"
	Then no client is found
	