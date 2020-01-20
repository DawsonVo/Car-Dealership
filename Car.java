//Dawson Vo - 500879711
import java.util.*; //import all java.util (For Comparator interface)
public class Car extends Vehicle implements Comparable<Car>
{
  //instance variables for class Car: model, maxRange, safetyRating, AWD, price
  private String model; 
  private int maxRange;
  private double safetyRating;
  private boolean AWD;
  private double price;
  //contants
  static final String SEDAN = "SEDAN";
  static final String SUV = "SUV";
  static final String SPORTS = "SPORTS";
  static final String MINIVAN = "MINIVAN";
  
  //Constructor method for class Car
  public Car(String mfr, String color,String model, String engine,double safetyRating,int maxRange,String driveType,double price)
  {
    //initialize inherited variables of Vehicle class
    super(mfr,color,engine,4);//for car class numWheels if default to 4 (4 wheels on a car)
    
    //set class Car's instance variables
    this.safetyRating = safetyRating;
    this.maxRange = maxRange;
    this.price = price;
    //checks if the string driveType is "AWD" or not: if is "AWD" set AWD to true, else false
    //there is only AWD or 2WD, thus AWD == false means 2WD
    if(driveType.equals("AWD"))
    {
      AWD = true;
    }
    else
    {
      AWD = false;
    }
    if(model.equals("SEDAN"))
    {
      this.model = SEDAN;
    }
    else if (model.equals("SUV"))
    {
      this.model = SUV;
    }
    else if (model.equals("SPORTS"))
    {
      this.model = SPORTS;
    }
    else if (model.equals("MINIVAN"))
    {
      this.model = MINIVAN;
    }
    else
    {
      this.model = "Null";
    }
  }
  
  
  //return Vehicles display method (mfr and color, seperated by space), appended with instance variables of Car class, seperated by spaces "$","SF:","RNG:" where necessary
  public String display()
  {
    return super.display() + " " + model + " " + price + "$ SF: " + safetyRating + " RNG: " + maxRange;//edit so it outputs for electric cars
  }
  
  //Used to check if this Car object is equal to another Car object
  //Based on variables: mfr, power, numWheels, model, AWD
  public boolean equals(Object other)
  {
    //Create a Car object other
    Car otherCar = (Car) other;
    //Assume equivalance until proven otherwise
    boolean output = true;
    //if equals method inherited from Vehicle class outputs false it is not necessary to check further, they are not equavalent, set output to false
    if(super.equals(otherCar))
    {
      //if inherited equals method is true, check further for if model and AWD variables are equal
      //if not equalivalent set output to false
      if(!model.equals(otherCar.model))
      {
        output = false;
      }
      if(AWD != otherCar.AWD)
      {
        output = false;
      }
    }
    else
    {
      output = false;
    }
    return output;
  }
  
  
  //compareTo method to implement inherited abstract method from Comparable interface
  //return -1 if price of current Car object if less than other Car object
  //return 1 if  price of current Car object if more than other Car object
  //return 0 if price of current Car object and other Car object are equal
  public int compareTo(Car other)
  {
  
    if (this.price - other.price<0)//difference being <0 means other Car object's price is greater
    {
      return -1;
    }
    else if (this.price - other.price>0)//difference being >0 means current Car object's price is greater
    {
      return 1;
    }
    else//difference is 0, thus prices are equal
    {
      return 0;
    }
  }
  
  //SET AND GET METHODS FOR ALL REFERENCE VARIABLES
  public String getModel()
  {
     return model;
  }
  public int getMaxRange()
  {
     return maxRange;
  }
  public double getSafetyRating()
  {
     return safetyRating;
  }
  public boolean getAWD()
  {
     return AWD;
  }
  public double getPrice()
  {
     return price;
  }
  public void setModel(String model)
  {
     this.model = model;
  }
  public void setMaxRange(int maxRange)
  {
     this.maxRange = maxRange;
  }
  public void setSafetyRating(double safetyRating)
  {
     this.safetyRating = safetyRating;
  }
  public void setAWD(boolean AWD)
  {
     this.AWD = AWD;
  }
  public void setPrice(double price)
  {
     this.price = price;
  }
  
  
  //returns false because this class does not represents an electric vehicle, class ElectricCar has same method that returns true
  public boolean isElectric()
  {
    return false;
  }
}
//class implementing the Comparator Interface used as an alternate way to sort using Collections.sort(ArrayList,Comparator)
//allows the Collections class to sort using values of the safetyRating variable from the Car Class
class compareSR implements Comparator<Car>
{
  //method called compare. Using Collections.sort(ArrayList,Comparator) calls for the method compare unlike Collections.sort(ArrayList) which calls for compareTo
  public int compare(Car a, Car b)
  {
    if (a.getSafetyRating() - b.getSafetyRating()<0)//if Car object a is smaller than Car object b the sum is less than 0, return 1 unlike the compareTo() method. This is because we want to sort from greatest to smallest
    {
      return 1;
    }
    else if (a.getSafetyRating() - b.getSafetyRating()>0)//if Car object a is greater than Car object b the sum is greater than 0, return -1 unlike the compareTo() method. This is because we want to sort from greatest to smallest
    {
      return -1;
    }
    else//equals return 0
    {
      return 0;
    }
  }
}
  
  
  
//class implementing the Comparator Interface used as an alternate way to sort using Collections.sort(ArrayList,Comparator)
//allows the Collections class to sort using values of the maxRange variable from the Car Class
class compareMR implements Comparator<Car>
{
  
   //method called compare. Using Collections.sort(ArrayList,Comparator) calls for the method compare unlike Collections.sort(ArrayList) which calls for compareTo
  public int compare(Car a, Car b)
  {
    if (a.getMaxRange() - b.getMaxRange()<0)//if Car object a is smaller than Car object b the sum is less than 0, return 1 unlike the compareTo() method. This is because we want to sort from greatest to smallest
    {
      return 1;
    }
    else if (a.getMaxRange() - b.getMaxRange()>0)//if Car object a is greater than Car object b the sum is greater than 0, return -1 unlike the compareTo() method. This is because we want to sort from greatest to smallest
    {
      return -1;
    }
    else
    {
      return 0;
    }
  }
}