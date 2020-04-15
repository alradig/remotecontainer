Feature: Logistic company can search for a client

Background: The logistic company has a set of clients
	Given that the logistic company is logged in 
	And these clients are in the system
		| BananaExpress | Bob | bob@mail.com |
		| HappyPrint | Jiayi | jiayi@mail.com |
		| CakeDay | Ida | ida@mail.com | 
	And the logistic company logs out 
	
Scenario: Searching for client
	Given that the logistic company is logged in 
	When the logistic company search for "bob@mail.com"
	Then the client "BananaExpress" is found
	
	
	