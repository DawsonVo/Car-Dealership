//Dawson Vo - 500879711
import java.util.Random;
import java.util.ArrayList;
public class Vehicle
{
  //Instance Variables: mfr, color, power, numwheels
  private String mfr;
  private String color;
  private int power;
  private int numWheels;
  private int VIN;
  private static ArrayList <Integer> usedVin; 
  //constants: ELECTRIC_MOTOR, GAS_ENGINE
  static final int ELECTRIC_MOTOR = 1;
  static final int GAS_ENGINE = 0;
  
  //-------------------------------------------------------------------------------------------------------------------
  //Constructor
  public Vehicle (String mfr, String color,String engine,int numWheels)
  {
    //setting instance variables: mfr, color, numWheels
    this.mfr = mfr;
    this.color = color;
    this.numWheels = numWheels;
    //Check value of string engine then set power to the according constant
    if(engine.equals("GAS_ENGINE"))
    {
      power = GAS_ENGINE;
    }
    if(engine.equals("ELECTRIC_MOTOR"))
    {
      power = ELECTRIC_MOTOR;
    }
    else
    {
      power = -1;
    }
    Random random = new Random();
    if(usedVin==null)
    {
      usedVin = new ArrayList<Integer>() ;
    }
    VIN = random.nextInt(400)+100;
    while(usedVin.contains(VIN))
    {
      VIN = random.nextInt(400)+100;
    }
    usedVin.add(VIN);
    
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  //Used to check if this Vehicle object is equal to another Vehicle object
  //Based on variables: mfr, power, numWheels
  public boolean equals(Object other)
  {
    //Create another Vehicle object called other
    Vehicle otherVehicle = (Vehicle) other;
    //Assume they are equivalent until an if statement sets it to false
    boolean output = true;
    //Check for when: mfr, power, numWheels are not equal between both Vehicle Objects
    if(!this.mfr.equals(otherVehicle.getMfr()))
    {
      output = false;
    }
    if(this.power != otherVehicle.getPower())
    {
      output = false;
    }
    if(this.numWheels != otherVehicle.getNumWheels())
    {
      output = false;
    }
    return output;
    
  }
  
  //set mfr variable
  public void setMfr(String a)
  {
    mfr = a;
  }
  
  //set color variable
  public void setColor(String a)
  {
    color = a;
  }

  
  //set power variable
  public void setPower(int a)
  {
    power = a;
  }
  
  
  //set numWheels variable
  public void setNumWheels(int a)
  {
    numWheels = a;
  }
  
  
  //return mfr variable
  public String getMfr()
  {
    return mfr;
  }
  
  //return color variable
  public String getColor()
  {
    return color;
  }
  
  
  //return power variable
  public int getPower()
  {
    return power;
  }
  
  
  //return numWheels variable
  public int getNumWheels()
  {
    return numWheels;
  }
 
  public void setVIN(int a)
  {
    VIN = a;
  }
  public int getVIN()
  {
    return VIN;
  }
  
  //return mfr and color, seperated by a space
  public String display()
  {
    return ("VIN: " + VIN + " " + mfr + " " + color);
  } 
  
}