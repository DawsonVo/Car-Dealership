//Dawson Vo - 500879711

import java.util.*; //import util - LinkedList, ListIterator
public class SalesTeam
{
   //instance variable
  LinkedList <String> team = new LinkedList <String> ();
  //constructor method initialize and adds sales people to team LinkedList
  public SalesTeam()
  {
    team.add("John");
    team.add("David");
    team.add("Alexa");
    team.add("Ann");
    team.add("Vy");
    
  }
  //getSalesRep method
  //returns random sales person from team LinkedList
  public String getSalesRep()
  {
    Random rand = new Random();
    return team.get(rand.nextInt(team.size()));
    
    
  }
  
  //getTeam method
  //returns entire sales team
  public String getTeam()
  {
     //ListIterator for team LinkedList
    ListIterator<String> person = team.listIterator();
    String out = "Team: ";
    //while there is another team member - add member to string out with "," following
    while(person.hasNext())
    {
      out+=person.next()+ ", ";
    }
    
    return out;
    
    
  }
}