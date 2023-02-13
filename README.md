# Car Dealership Simulator
**Academic project to recreate a car dealership inventory system**


Includes File I/O. INCLUDES EXCEPTION HANDLING ON "BUY" AND "FPR"


**Commands**\
- "L" - list inventory
- "Q" - quit
- "ADD" - Add vehicles from file
- "FPR" - Filter between min and max price
- "FEL" - Filter only electric vehicles
- "FAW" - Fileter only all wheel drive vehicles
- "FCL" - clears all filters
- "SPR" - sort the cars by price (least to greatest)
- "SSR" - sort the cars by safetyRating(greatest to lowest)
- "SMR" - sort the cars by maxRange (greatest to lowest)
- "SALES [ month: 0-9 ]" - 0=jan, 1=feb, etc
- "SALES TEAM" - Prints sales team formatted "Team: " salesperson ", " salesperson ", " ...etc
- "SALES TOPSP" - Prints top sales person(s) - prints 2 if 2 are tied, 3 if 3 are tied etc
- "SALES STATS" - Prints sales stats as formatted in video example
- "RET" modified to return last car based on VIN of last car bought
		
		- Returns do not affect amount of cars sold, but does affect sales amount ($$$) and avg sales per month ($$$)
		eg. Bob sells a car in Feb then it gets returned by bob
			Bob - 1 sales, Feb - 1 car sold
			total sales ($$) - $0
	
- "BUY" modified to buy car based on VIN


Run CarDealershipSimulator.java

Requires
- Car.java
- CarDealership.java
- ElectricCar.java
- Vehicle.java
- cars.txt    -    For File I/O
- AccountingSystem.java
- Transaction.java
- SalesTeam.java


