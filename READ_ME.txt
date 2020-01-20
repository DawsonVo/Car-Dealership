Dawson Vo - 500879711
Everything works. 
Includes File I/O. INCLUDES EXCEPTION HANDLING ON "BUY" AND "FPR"

Assignment 2 Updates:
AccountingSystem class
Transaction class - unique Transaction ID for each Transaction
SalesTeam class
Vehicle class modified for VIN - unique VIN for each vehicle
CarDealership class modified - New instance variables for AccountingSystem and Transation and commands for SALES Commands
All SALES commands work
"SALES"
"SALES m" - 0=jan, 1=feb, etc
"SALES TEAM" - Prints sales team formatted "Team: " salesperson ", " salesperson ", " ...etc
"SALES TOPSP" - Prints top sales person(s) - prints 2 if 2 are tied, 3 if 3 are tied etc
"SALES STATS" - Prints sales stats as formatted in video example

	- Returns do not affect amount of cars sold, but does affect sales amount ($$$) and avg sales per month ($$$)
		eg. Bob sells a car in Feb then it gets returned by bob
			Bob - 1 sales, Feb - 1 car sold
			total sales ($$) - $0
cars.txt now contains 24 cars
"RET" modified to return last car based on VIN of last car bought
	Returns will happen within the month car was bought 
		eg Bought April 30 Returned April 30
		   Bought April 20 Returned April 20-30
	
"BUY" modified to buy car based on VIN


Run CarDealershipSimulator.java

Requires
-Car.java
-CarDealership.java
-ElectricCar.java
-Vehicle.java
-cars.txt    -    For File I/O
-AccountingSystem.java
-Transaction.java
-SalesTeam.java

Fixed Possible Errors
-RET without first buying a car
-BUY command not followed by anything or followed by a non number
-FPR command not followed by anything or followed by non numbers
