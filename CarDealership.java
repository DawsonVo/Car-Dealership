//Dawson Vo - 500879711
import java.util.*;//import all util - ArrayList, Random, Calendar, GregorianCalendar, Random, Collections
import java.text.SimpleDateFormat;//import SimpleDateFormat for Calendar and GregorianCalendar 

public class CarDealership
{
   SalesTeam team = new SalesTeam();
   AccountingSystem aSys = new AccountingSystem();
   ////////////////////////////////////////////////////////////////////////////////////////////
   //ArrayList containing all the cars the dealership has
   private ArrayList <Car> cars;
   //booleans conditions for filtering: filter; electric vehicles, AWD vehicles, vehicles within price range
   private boolean fElec = false;
   private boolean fAWD = false;
   private boolean fPrice = false;
   //min price and max price for filtering price
   //only used when fPrice == true
   private double minPrice = 0;
   private double maxPrice = Double.MAX_VALUE;
   
   
   //constructor initializing ArrayList cars
   public CarDealership()
   {
      cars = new ArrayList<Car>();
   }
   
   //add all indexs from ArrayList newCars to Arraylist cars
   public void addCars(ArrayList<Car> newCars)
   {
      cars.addAll(newCars);
   }
   
   //removes car from ArrayList cars(removes car from dealership)
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public String buyCar(String vin) throws RuntimeException
   {
      //check if variable index is within bounds of the ArrayList cars
      //if it is out of bounds it returns null
      int VIN = Integer.parseInt(vin);
      boolean found = false;
     for (int i = 0; i<cars.size();i++)
     {
       if (cars.get(i).getVIN() == VIN)
       {
         found = true;
         //remove car from array
         //create random date
         Random rand = new Random();
         int month = rand.nextInt(12); //0-11
         Calendar date = new GregorianCalendar(2019, month,0);
         int day = rand.nextInt(date.getMaximum(GregorianCalendar.DAY_OF_MONTH));
         date = new GregorianCalendar(2019, month, day);
         double price = cars.get(i).getPrice();
         return aSys.add(date,cars.remove(i),team.getSalesRep(),"BUY", price);
         
         //add the car to accounting system
         
         
       }
     }
     if(found == false)
     {
       throw new RuntimeException();
     }
     return null;
     
   }
   
   //adds the reference car object back into the dealership class's ArrayList cars
   public void returnCar(int VIN)
   {
     //checks if the reference is null
      if (VIN != -1)
      {
        Transaction trans = aSys.getTransaction(VIN);
        cars.add(trans.car);
         
         Random rand = new Random();
         SimpleDateFormat sdf = new SimpleDateFormat("dd");
         Calendar date = (Calendar) trans.date.clone();
         int dayOffset = rand.nextInt(date.getMaximum(GregorianCalendar.DAY_OF_MONTH)-Integer.parseInt(sdf.format(date.getTime())));
         
         date.roll(GregorianCalendar.DAY_OF_MONTH, dayOffset);
         System.out.println(aSys.add(date, trans.car, trans.salesAssociate, "RET", trans.salePrice));
      }
   }
   
   //displays each index of ArrayList cars that match the set conditions of filters
   public void displayInventory()
   {
      //for loops through each index of ArrayList cars
      for (int i = 0; i<cars.size();i++)
      {
        //boolean canOutput is checked at the end to see if it should be outputed
        //is also checked to be true at each if statement to prevent false being reverted to true(ie fElec==true, fAWD == true, if fElec sets canOutput to false, then fAWD sets it to true it will output even when it doesnt fufil fElec)
         boolean canOutput = true;
         
         //if fElec is true (Filter only Electric cars displayed) and canOutput is true check if the vehivle is electric or not with the isElectric method
         //then sets the status of canOutput to the return of that method. If it is an electric car then canOutput remains true, if it is not then canOutput is set to false and the car is filtered out
         if (fElec == true && canOutput==true)
         {
            canOutput = cars.get(i).isElectric();
         }
         
         //if fAWD is true (output cars that are AWD) and canOutput is true check if the car is AWD or not by grabbing the AWD boolean variable
         //then sets the status of canOutput to the variable AWD. If the vehicle is AWD then canOutput remains true, if it is not canOutput is set to false and the car is filtered out
         if (fAWD == true && canOutput == true)
         {
            canOutput = cars.get(i).getAWD();
         }
         
         //if fPrice is true(output cars that are within the price range) and canOutput is true, checks if price variable is within minPrice and maxPrice
         //sets canOutput to false if it is outside bounds of minPrice and maxPrice
         if (fPrice == true && canOutput==true)
         {
            
            if (minPrice>cars.get(i).getPrice() || cars.get(i).getPrice()>maxPrice)
            {
               canOutput = false;
            }
         }
         //checks if it can display the Car object
         if(canOutput)
         {
            System.out.println(cars.get(i).display());
         }
      }
   }
   
   //sets filter booleans to false and minPrice and maxPrice to min and max values
   public void filtersClear()
   {
      fElec = false;
      fAWD = false;
      fPrice = false;
      minPrice = 0;
      maxPrice = Double.MAX_VALUE;
   }
   
   //sets fElec to true
   public void filterByElectric()
   {
      fElec = true;
   }
   
   //sets fAWD to true
   public void filterByAWD()
   {
      fAWD = true;
   }
   
   //sets fPrice to true and sets minPrice and maxPrice
   public void filterByPrice(String minPrice, String maxPrice) throws RuntimeException
   {
      this.minPrice = Double.parseDouble(minPrice);
      this.maxPrice = Double.parseDouble(maxPrice);
      fPrice = true;
   }
   
   //sorts using the compareTo() method in Car class to sort by price least to greatest
   public void sortByPrice()
   {
      Collections.sort(cars);
   }
   
   //sorts using the Comparator interface using the class compareSR
   //sorts from greatest safetyRating to lowest
   public void sortBySafetyRating()
   {
      compareSR compare = new compareSR();
      Collections.sort(cars,compare);
   }
   
   //sorts using the Comparator interface using the class compareMR
   //sorts from greatest maxRange to lowest
   public void sortByMaxRange()
   {
      compareMR compare = new compareMR();
      Collections.sort(cars,compare);
   }
   
   //calls getTeam method from SalesTeam object
   //outputs names of Entire sales team
   public void getTeam()
   {
     System.out.println(team.getTeam()); 
   }
   
   //calls salesRecords method from AccountingSystem object
   //outputs all transactions
   public void salesRecords()
   {
        aSys.salesRecords();
   }
   //calls salesRecordsM method from AccountingSystem object
   //outputs all transactions for specified month
   public void salesRecordsM(int month)
   {
        aSys.salesRecordsM(month);
   }
   //calls getSPTop method from AccountingSystem object
   //output the sales person with the most sales made
   public void getSPTop()
   {
        aSys.getSPTop();
   }
   //calls getStats method from AccountingSystem object
   //outputs summary of all transaction
   public void getStats()
   {
        aSys.getStats();
   }
   
}
