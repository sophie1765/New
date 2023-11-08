import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * The WorldOfRobot class will allow the construction of the world where the robots created will 
 * evolve and move without collision
 *
 * @author (Group 6)
 * @version (26/10/2023)
 */
public class WorldOfRobot
{
    //Position x of the robot in the world 
    private int x;
    //Position y of the robot in the world 
    private int y;
    //Declaration of the list robot that will store the robots
    private ArrayList<Robot> robot;
    
    private CanvasRobot canvasRobot;
    
    private int numberRobots;
    

    /**
     * The constructor of the WorldOfRobot class
     */
    public WorldOfRobot()
    {
        //Initialization of the list that will contain the robots
        this.robot=new ArrayList<Robot>();        
    }

    /**
     * This method is used to return the list of robots that have been created in the world
     *
     * @return     the list of robot
     */
    public ArrayList<Robot> getRobotList ()
    {
        //Returns the list of robots
        return this.robot;
    }
    
    /**
     * This method makes it possible to check that the box where the robot will move is free 
     * 
     * @param       the x position of the robot and the y position of the robot 
     * @return      return false if is not available and return true if is available
     */
    public boolean checkLocationAvailable (int x,int y)
    {
        int a=0;
        int b=robot.size();
        while(a < b)
        {
            if(robot.get(a).getX()==x && robot.get(a).getY()==y)
            {
                return false;
            }
            a++;
        }
        return true;
    }
    
    /**
     * This method adds the robot Tournicoti
     */
    public void addTournicotiRobot(String nameRobot, int x, int y)
    {
        if(checkLocationAvailable(x,y))
        {
            TournicotiRobot tournicoti=new TournicotiRobot(nameRobot,x,y,this);
            tournicoti.viewRobot();
            robot.add(tournicoti);
        }
    }
    
    
    /**
     * This methods adds the robot CornerRobot
     */
    public void addCornerRobot (String nameRobot, int x, int y)
    {
        if (checkLocationAvailable(x,y))
        {
            CornerRobot corner=new CornerRobot (nameRobot, x, y, this);
            corner.viewRobot();
            robot.add(corner);
        }
    }
    
    /**
     * This methods adds the robot RandomSpeedRobot
     */
    public void addRandomSpeedRobot (String nameRobot, int x, int y) 
    {
        if (checkLocationAvailable(x,y))
        {
            RandomSpeedRobot random=new RandomSpeedRobot (nameRobot, x, y, this);
            random.viewRobot();
            robot.add(random);
        }
    }
    
    /**
     * This methods adds the robot Robotprime
     */
    public void addRobotprime (String nameRobot, int x, int y)
    {
        if (checkLocationAvailable (x,y))
        {
            Robotprime prime= new Robotprime (nameRobot, x, y, this);
            prime.viewRobot();
            robot.add(prime);
        }
    }
    
    /**
     * This methods adds the robot LRobot
     */
    public void addLRobot (String nameRobot, int x, int y)
    {
        if (checkLocationAvailable (x,y))
        {
            LRobot L= new LRobot (nameRobot, x, y, this);
            L.viewRobot();
            robot.add(L);
        }
    }
        
    
    /**
     * This method allows to register all the robots created in the world 
     */
    public void registerAllRobots ()
    {
        //pour ajouter les robots
        // addnom du robot("nom qu'on veut lui donner", position x, position y);
      addTournicotiRobot("Tournicoti",4,4);
      addCornerRobot("Corner", 0, 0);
      addRandomSpeedRobot ("Random", 0, 8);
      addRobotprime ("prime", 1, 1);
      addLRobot ("L", 1,0);
        
    }
    
    /**
     * This method allows to add robots
     */
    public void addRobot(Robot rob)
    {
        this.robot.add(rob);
    }
            
    /**
     * This method allows all robots to move once at the same time 
     */
    public void moveAllRobots ()
    {
        for (Robot robots : robot)
        {
            robots.move();
        }
    }
    
    /**
     * This method makes it possible to move all the robots one by one with a chosen number of turns
     */
    public void moveSeveralTimes (int m)
    {
        int cpt=0;
        while(cpt<m)
        {
            for(int i=0; i<robot.size(); i++)
            {
                robot.get(i).move();
                try
                {
                    TimeUnit.MILLISECONDS.sleep(500);
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                cpt++;
            }
        }
    }   
    
    /**
     * Methods to have the number of robot in the list
     * @return number Robots
     */
    public int getNumberRobots ()
    {
        numberRobots= robot.size();
        return numberRobots;
    }
}
