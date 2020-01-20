//Dawson Vo - 500879711
import java.util.*;//import all util - ArrayList, Map, Calendar, GregorianCalendar, Random
import java.text.SimpleDateFormat;

public class AccountingSystem
{
   //instance variables
   ArrayList<Transaction> transactions = new ArrayList<Transaction>();//Array List containing all transaction objects
   int topSPAmount;//stores value for most sales - The array list will be searched for all sales persons that match this number
   Map<String, Integer> salesAmount = new HashMap<String,Integer>();//Map that holds each person in the sales team and their corresponding amount of sales
   private static ArrayList <Integer> usedID;//static ArrayList containing all transaction ID that are already used to there will be no duplicates
   
   //add method that creates a Transaction object and adds it to the ArrayList transactions
   public String add(Calendar date, Car car, String salesPerson, String type, double salePrice)
   {
      //creating a random id from 1-99
      Random rand = new Random();
      if(usedID==null)
      {
         usedID = new ArrayList<Integer>() ;
      }
      int id = rand.nextInt(99)+1;
      //if the random id generated has already been used then generate a new id
      while(usedID.contains(id))
      {
         id = rand.nextInt(99)+1;
      }
      //add the id to usedID to prevent it from being used again
      usedID.add(id);
      
      //creating a Transaction object
      Transaction newTrans = new Transaction(id,date,car,salesPerson,type,salePrice);
      //adding Transaction object to ArrayList transactions
      transactions.add(newTrans);
      
      //if the Transaction if of the type BUY (it is a sale not return) increase the corresponding sales person's sales number by 1
      //if there is no mapping for that sales person create one to the value 1
      if (type.equals("BUY")){
         if(salesAmount.containsKey(salesPerson))
         {
            salesAmount.replace(salesPerson,salesAmount.get(salesPerson)+1);
         }
         else
         {
            salesAmount.put(salesPerson,1);
         }
         //if the amount of sales this sales person has is greater then the current top sales amount, update it to the new top sales amount
         if(salesAmount.get(salesPerson) > topSPAmount)
         {
            topSPAmount = salesAmount.get(salesPerson);
         }
      }
      //return the display method of the Transaction object
      return newTrans.display();
   }
   
   
   //getTransaction method - Looks through transactions ArrayList for Transaction objects that contain the ID specified and return the object
   public Transaction getTransaction(int id)
   {
      
      //looking through transactions ArrayList
      for(int i = 0; i<transactions.size();i++)
      {
         if(transactions.get(i).transID == id)
         {
            return transactions.get(i);
         }
      }
      //if not found return null
      return null;
   }
   
   //salesRecords method - used for "SALES" command
   //outputs all Transaction objects from transactions ArrayList (outputs every transaction that took place)
   public void salesRecords()
   {
      for (int i = 0; i<transactions.size(); i++)
      {
         System.out.println(transactions.get(i).display());
      }
      
      
   }
   
   //salesRecordsM method - used for "SALES m" command
   //outputs all Transaction objects from transactions ArrayList that are of the month specified (1 = jan, 2 = feb, etc)
   //The value of month is already fixed in CarDealershipSimulator - user input + 1 (userinput = 0 -> jan, userinput = 1 -> feb, etc)
   public void salesRecordsM(int month)
   {
      //looks through transactions ArrayList
      for (int i = 0; i<transactions.size(); i++)
      {
         //format to output value of month (1=jan, 2 =feb,etc)
         SimpleDateFormat sdf = new SimpleDateFormat("MM");
         //if the value of the month == the specified month then output the transaction
         if(Integer.parseInt(sdf.format(transactions.get(i).date.getTime())) == month)
         {
            System.out.println(transactions.get(i).display());
         }
      }
   }
   
   //setSPStats methods - used for "SALES TOPSP" command
   //outputs any sales person that has as much sales as the topSPAmount variable
   public void getSPTop()
   {
      //loop through entire salesAmount Map
      for(String a:salesAmount.keySet())
      {
         //if the amount of sales for an employee matches the value for top amount of sales output their name
         if (salesAmount.get(a)==topSPAmount)
         {
            System.out.println("Top SP: " +a + " " + salesAmount.get(a));
         }
      }
   }
   //getStats method - used for "SALES STATS" Command
   //outputs summary of all transactions for the year
   public void getStats()
   {
      //temp variables for holding values as theyre calculated
      double totalSales = 0;
      int totalCarsSold = 0;
      int totalCarsRet = 0;
      int avgSalesPM = 0;
      Map <String, Integer> months = new HashMap<String, Integer>();//holds ammount of cars sold that month
      int bestSalesPM = 0;
      String BestMonth = "";
      //format to output month name
      SimpleDateFormat sdf = new SimpleDateFormat("MMM");
      //loop through all transactions
      for (int i = 0; i<transactions.size(); i++)
      {
         //getting type of transaction
         String type = transactions.get(i).transType;
         
         //if BUY transaction type
         if(type.equals("BUY"))
         {
            totalSales+=transactions.get(i).salePrice;//add to totalSales the worth of car sold
            totalCarsSold++;//add to totalCarsSold 1
            String currMonth = sdf.format(transactions.get(i).date.getTime());//get month name
            //if the Map contains the month already increment value mapped to month by 1
            if(months.containsKey(currMonth))
            {
               months.replace(currMonth,months.get(currMonth)+1 );
            }
            //else create the month mapped to 1
            else
            {
               months.put(currMonth,1);
            }
            //if the month has more sales then bestSalesPM update the value of bestSalesPM
            if (months.get(currMonth)>bestSalesPM)
            {
               bestSalesPM = months.get(currMonth);
               BestMonth = currMonth;
            }
         }
         //if the transaction is RET type
         else if(type.equals("RET"))
         {
            totalSales-=transactions.get(i).salePrice;//decrease totalSales by worth of car returned
            totalCarsRet++;//add to totalCarsRet 1
            
         }
      }
      //averages sales per month will be totalSales in the year divided by 12 months
      avgSalesPM = (int)totalSales/12;
      //output all calculated stats formatted as specified
      System.out.println("Total Sales: " + totalSales + " Total Sold: " + totalCarsSold +  " Avg Sales: " + avgSalesPM + " Total Returned: " + totalCarsRet + " Best Month: " + BestMonth + ": Cars Sold - " + bestSalesPM);
   }
}