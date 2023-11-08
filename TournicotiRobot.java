
/**
 * This class allows the robot to move in circles
 *
 * @author (Sophie Bordes)
 * @version (26/10/2023)
 */
public class TournicotiRobot extends Robot
{
    //Defines the direction of the robot 
    private int direction=1;
    //Allows you to set the speed of the robot 
    private int tournicotiSpeed=0;
    //Allows to define the position x of the robot 
    private int xPos=4;
    //Allows to define the position y of the robot 
    private int yPos=4;

    

    /**
     * The constructor of the TournicotiRobot class
     */
    public TournicotiRobot(String nameRobot, int x, int y, WorldOfRobot wor)
    {
        super(nameRobot, x, y, wor);
        super.setColourBody("YELLOW");
        wor.addRobot(this);
        viewRobot();
    }

    /**
     * This method makes it possible to move the robot in circles 
     */
    public void move ()
    {
        int xPosition= getX();
        int yPosition= getY();
        
        if(direction==1)
        {
            xPos=xPos+1+tournicotiSpeed;
        }
        else if(direction==2)
        {
            yPos=yPos+1+tournicotiSpeed;
        }
        else if(direction==3)
        {
            xPos=xPos-1-tournicotiSpeed;
        }
        else
        {
            yPos=yPos-1-tournicotiSpeed;
        }
        direction++;
        if(direction==5)
        {
            direction=1;
        }
        tournicotiSpeed++;
        if(tournicotiSpeed==6)
        {
            tournicotiSpeed=0;
            setPosition(0,11);
        }
        if(checkLocationAvailable(xPos,yPos))
        {
            xPosition=xPos;
            yPosition=yPos;
            setPosition(xPosition, yPosition);
        }
        else
        {
            if(checkLocationAvailable(4,4))
            {
                xPosition=4;
                yPosition=4;
                setPosition(xPosition, yPosition);
            }
        }
        viewRobot();
    }
}
