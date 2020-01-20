//Dawson Vo - 500879711
import java.util.ArrayList;//import ArrayList
import java.util.Scanner;//import Scanner
import java.io.File;//import File
public class CarDealershipSimulator 
{
     public static void main(String[] args)
     {
          //Car object lastCar, stores the reference to that last bought car
          String lastCar = null;
          
          
          
          
          // Create a CarDealership object
          // Then create an (initially empty) array list of type Car
          // Then create some new car objects of different types
          // See the cars file for car object details
          // Add the car objects to the array list
          // The ADD command should hand this array list to CarDealership object via the addCars() method   
          CarDealership dealership = new CarDealership();//CarDealership object
          ArrayList <Car> car = new ArrayList<Car>();//ArrayList car which will be populated with cars from file input
          fileReader("cars.txt", car);//method to read cars from file "cars.txt" also send reference to ArrayList car as parameter
          
          
          // Create a scanner object
          Scanner scan = new Scanner(System.in);
          while (scan.hasNextLine())
          {
               String input = scan.nextLine();//takes user input as a whole line
               Scanner commandLine = new Scanner(input);//scanner that reads the user input in "segments"
               
               //if the input is not empty/nothing
               if(!input.equals(""))
               {
                    //command is just a string that contains the first word from the user input line
                    String command = commandLine.next().toUpperCase();
                    //System.out.println(command);//outputs the command
                    
                    //if statements that check possible commands:L,Q,BUY,RET,ADD,FPR,FEL,FAW,SPR,SSR,SMR
                    //if it doesnt match any of these commands it just loops again to taking user input
                    //displays all cars that match the required filter conditions: calls displayInventory() method from CarDealership class
                    if (command.equals("L"))
                    {
                         dealership.displayInventory();
                    }
                    //quits the program by breaking out of the while loop
                    else if (command.equals("Q"))
                    {
                         break;
                    }
                    //buys a car by taking in the next input which should be an integer then calling the buyCar(index) method from CarDealership class
                    //the buyCar(index) method also returns a reference to the car bought which is set to the Car object lastCar
                    else if (command.equals("BUY"))
                    {
                         try//trys to scan next then parse it into an int
                         {
                              String index = commandLine.next();
                              //System.out.println(dealership.cars.get(index).display());
                              lastCar = dealership.buyCar(index);
                              System.out.println(lastCar); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////fuix
                         }
                         catch (RuntimeException e)//catches exception for when user does not enter format expected (BUY #)
                         {
                              System.out.println("You have not entered a valid VIN number or there are no cars available for purchase");
                         }//also catches exception for when user does not follow BUY command with anything
                    }
                    //puts the last bought car back into the dealership object's ArrayList
                    //done by giving lastCar object as parameter then setting it to null so it cant be returned again (You cant return a car that is already returned)
                    else if (command.equals("RET"))
                    {
                         int VIN = -1;
                         try
                         {
                              Scanner scanVIN = new Scanner(lastCar);
                              scanVIN.next();
                              VIN = scanVIN.nextInt();
                              scanVIN.close();
                         }
                         catch (NullPointerException n)
                         {
                              System.out.println("There is no vehicle to return");
                         }
                         dealership.returnCar(VIN);
                         lastCar = null;
                         
                    }
                    //adds ArrayList car, which contains all car objects from file reading into the CarDealership object dealership's ArrayList
                    else if (command.equals("ADD"))
                    {
                         dealership.addCars(car);
                    }
                    
                    //Reads next two doubles that represent minPrice and maxPrice
                    //sets filter to only display between min and max prices
                    else if (command.equals("FPR"))
                    {
                         try{//tries to filter by price
                              String min = commandLine.next();
                              String max = commandLine.next();
                              dealership.filterByPrice(min,max);
                         }
                         catch (RuntimeException e)//catches exception for when user does not enter format expected (FPR #.# #.#)or (FPR # #)
                         {
                              System.out.println("You have not entered a valid price range");
                         }
                    }
                    //sets filter to only display electric cars
                    else if (command.equals("FEL"))
                    {
                         dealership.filterByElectric();
                    }
                    //sets filter to only display AWD cars
                    else if (command.equals("FAW"))
                    {
                         dealership.filterByAWD();
                    }
                    //clears all filters
                    else if (command.equals("FCL"))
                    {
                         dealership.filtersClear();
                    }
                    //sort the cars by price (least to greatest)
                    else if (command.equals("SPR"))
                    {
                         dealership.sortByPrice();
                    }
                    //sort the cars by safetyRating(greatest to lowest)
                    else if (command.equals("SSR"))
                    {
                         dealership.sortBySafetyRating();
                    }
                    //sort the cars by maxRange (greatest to lowest)
                    else if (command.equals("SMR"))
                    {
                         dealership.sortByMaxRange();
                    }
                    
                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //if the first part of command is "SALES"
                    else if (command.equals("SALES"))
                    {
                         //if the command has more following it "SALES ------" 
                         if (commandLine.hasNext())
                         {
                              //secondCommand contains whatever follows "SALES" ("------")
                              String secondCommand = commandLine.next().toUpperCase();
                              //if secondCommand equals "TEAM" call the getTeam method
                              //outputs names of sales team
                              if (secondCommand.equals("TEAM"))
                              {
                                   
                                   dealership.getTeam();
                              }
                              
                              //if secondCommand equals "TOPSP" call the getSPTop method
                              //outputs the sales person with the most sales
                              else if (secondCommand.equals("TOPSP"))
                              {
                                   //print top sales person  Name: ,Cars Sold:
                                   //dealership.getSPStats();
                                   dealership.getSPTop();
                              }
                              
                              //if secondCommand equals "STATS" call the getStats method
                              //outputs summary of all transactions
                              else if (secondCommand.equals("STATS"))
                              {
                                   dealership.getStats();
                              }
                              
                              //if secondCommand equals a digit call the salesRecordsM method
                              //outputs all transactions of specified month (0=jan,1=feb,etc) + 1 (1=jan, 2,feb,etc)
                              else if(secondCommand.matches("(^\\d+$)"))//^ and $ mean start to end of string  \\d mean \d in regex which means is digit
                              {
                                   
                                   dealership.salesRecordsM(Integer.parseInt(secondCommand)+1);
                              }
                              
                              //else it is an invalid "SALES" command
                              else
                              {
                                   System.out.println("Invalid Sales Command");
                              }
                         }
                         
                         //if it does not have anything following the "SALES" command call salesRecords method
                         //outputs all transaction records in the year
                         else 
                         {
                              dealership.salesRecords();
                         }
                         
                    }
                    
                    
                    
                    
               }
               commandLine.close();//closes commandLine Scanner object 
               // while the scanner has another line
               //    read the input line
               //    create another scanner object (call it "commandLine" or something) using the input line instead of System.in
               //    read the next word from the commandLine scanner 
               // check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object  
          }
          
          scan.close();//closes scan Scanner object
          
     }
     public static void fileReader(String fileName, ArrayList<Car> car)
     {
          //create a File object called myFile that has fileName as parameter ("cars.txt")
          File myFile  =new File(fileName);
          //create Scanner object fileReader
          Scanner fileReader;
          //Try to initialize fileReader to scan from myFile
          //catches error where file is not found when trying to open to scan
          try{fileReader = new Scanner(myFile);}
          catch (Exception A){fileReader = null;}
          //while fileReader is not null(is initialized) and has another Line
          while (fileReader!=null&&fileReader.hasNextLine())//checks if fileReader is not null first. if it is null then it shortcircuits false
          {
               //input line is the entire line of input
               String inputLine = fileReader.nextLine();
               //ArrayLists carStats is how the information in cars.txt is split up on each line; lenght has to vary because electric cars have another stat(recharge time)
               ArrayList <String> carStats = new ArrayList<String>();
               //Scanner object carScanner splits the entire line of inputs into segments
               Scanner carScanner = new Scanner(inputLine);
               //this while loop reads each segment and adds it to the ArrayList as long as the scanner doesnt scan a " ", this is because there were multiple space between stats
               while (carScanner.hasNext())
               {
                    String stat = carScanner.next();
                    if(!stat.equals(" "))
                    {
                         carStats.add(stat);
                    }
               }
               
               //the 4th index in the ArrayList carStats will be the engine type
               //these if statements just check whether or not to create a ElectricCar object or a Car object for the line of intput
               if (carStats.get(3).equals("ELECTRIC_MOTOR"))
               {
                    car.add(new ElectricCar(carStats.get(0),carStats.get(1),carStats.get(2),carStats.get(3),Double.parseDouble(carStats.get(4)),Integer.parseInt(carStats.get(5)),carStats.get(6),Double.parseDouble(carStats.get(7)),Integer.parseInt(carStats.get(8))));
               }
               else if (carStats.get(3).equals("GAS_ENGINE"))
               {
                    car.add(new Car(carStats.get(0),carStats.get(1),carStats.get(2),carStats.get(3),Double.parseDouble(carStats.get(4)),Integer.parseInt(carStats.get(5)),carStats.get(6),Double.parseDouble(carStats.get(7))));
               }
               carScanner.close();//closes the Scanner object carScanner
          }
     }
}