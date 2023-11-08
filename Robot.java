
/**
 * The Robot class will be the superclass of all our robots
 *
 * @author (Group 6)
 * @version (26/10/2023)
 */
public class Robot
{
    //Position x of the robot in the world 
    private int x;
    //Position y of the robot in the world 
    private int y; 
    //The minimum position of the canvas
    private static final int minPosition=0;
    //The maximum position of the canvas
    private static final int maxPosition=11;
    //Using the CanvasRobot class to draw the robot 
    private CanvasRobot canvasRobot;
    //Using the Colour class to choose the color of the robot 
    private Colour colour;
    //Displays the world using the Canvas class
    private Canvas canvas;
    //Allows to choose the color of the robot
    private String colourBody;
    //The world in which the robot will evolve 
    private WorldOfRobot wor;
    //Allows to give a name to the robot
    private String nameRobot;
    

    /**
     * The constructor of the Robot class
     */
    public Robot(String nameRobot, int x, int y, WorldOfRobot wor)
    {
        this.wor= wor;
        this.canvasRobot= new CanvasRobot(colourBody);
        setName(nameRobot);
        if (wor.getNumberRobots()<100)
        {
            setPosition(x,y);
        }
    }

    /**
     * This method allows you to change the robot position 
     *
     * @param  y   x and y
     */
    public void setPosition (int xPosition, int yPosition)
    {
        if(x>=minPosition && x<=maxPosition && y>=minPosition && y<=maxPosition)
        {
            this.x=xPosition;
            this.y=yPosition;
        }
    }
    
    /**
     * Allows to have the position x
     */
    public int getX ()
    {
        return x;
    }
    
    /**
     * Allows to have the position y
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Allows you to change the color of the robot body
     */
    public void setColourBody(String colour)
    {
        this.colourBody=colour;
        canvasRobot.setColourBody(colour);
    }
    
    /**
     * Utiliser la méthode checkLocationAvailable de la classe WorldOfRobot
     */
    public boolean checkLocationAvailable (int x,int y)
    {
        return wor.checkLocationAvailable (x, y);
    }
    
    /**
     * This method allows the robot to move
     */
    public void move()
    {
        
    }
    
    /**
     * This method displays the robot
     */
    public void viewRobot()
    {
        this.canvasRobot.drawRobot(x, y);
    }
    
    /**
     * This method gives the name of the robot
     */
    public String getName()
    {
        return nameRobot;
    }
    
    /**
     * This method allows you to change the robot name
     */
    public void setName(String nameRobot)
    {
        this.nameRobot=nameRobot;
    }
}
