import java.util.*;//imports util - Calendar
import java.text.SimpleDateFormat;//imports SimpleDateFormat for Calendar
public class Transaction
{
   //instance variables
  int transID;
  Calendar date;
  Car car;
  String salesAssociate;
  String transType;
  double salePrice;
  
  //constructor method, assigns parameters to instance variables
  public Transaction (int transID, Calendar date, Car car, String salesPerson, String type, double salePrice)
  {
    this.transID = transID;
    this.date  = date;
    this.car = car;
    this.salesAssociate = salesPerson;
    this.transType = type;
    this.salePrice = salePrice;
  }
  //display method
  //returns String that contains all infomation from instance variables formatted as specified
  public String display()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");
    return "ID: " + transID + " " + sdf.format(date.getTime()) + " " + transType + " SalesPerson: " + salesAssociate + " " + car.display();
  }
  
}
  
  