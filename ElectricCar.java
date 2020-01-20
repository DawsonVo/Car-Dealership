//Dawson Vo - 500879711
public class ElectricCar extends Car
{
  //Instance variables of the ElectricCar class
  private int rechargeTime;
  private String batteryType;
  
  //constructor method for class ElectricCar
  public ElectricCar(String mfr, String color,String modl, String engine,double safetyR,int range,String driveType,double price,int rechargeTime)
  {
    //initialize inherited variables from the Car class
    super(mfr,color,modl,engine,safetyR,range,driveType,price);
    //sets this classes instance variables
    this.rechargeTime = rechargeTime;
    this.batteryType = "Lithium";
  }
  
  //return rechargeTime variable
  public int getRT()
  {
    return rechargeTime;
  }
  
  //return batteryType variable
  public String getBat()
  {
    return batteryType;
  }
  
  //set rechargeTime
  public void setRT(int RT)
  {
    rechargeTime = RT;
  }
  
  //set batteryType
  public void setBat(String Bat)
  {
    batteryType = Bat;
  }
  
  //return Cars display method (mfr and color with instance variables of Car class, seperated by spaces "$","SF:","RNG:" where necessary), appended with instance variables of ElectricCar class, seperated by spaces, "EL", " BAT:", "RCH:" where needed
  public String display()
  {
    return super.display() + " EL, BAT: " + batteryType + " RCH: " + rechargeTime;
  }
  public boolean isElectric()
  {
    return true;
  }
}