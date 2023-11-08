import java.util.Random;

/**
 * This class allow the robot to move only from one corner to another. 
 * It must always be in a corner and must not have an intermediate position. 
 * The robot can move diagonally or along the edge of the Canva.
 *
 *The CornerRobot is able to avoid other robots
 * @author (Aymeric Fernandez)
 * @version (26/10/2023)
 */public class CornerRobot extends Robot {

    private Random random;

    /**
     * The CornerRobot class constructor
     */
    public CornerRobot(String nameRobot, int x, int y, WorldOfRobot wor) {
        super(nameRobot, 0, 0, wor);
        super.setColourBody("GREEN");
        wor.addRobot(this);
        viewRobot();
        random = new Random();
    }

    /**
     * This method allows the robot to move along the corners 
     * of the canvas in a random way.
     */
    
    public void move() {
        int xPosition = getX();
        int yPosition = getY();

        int moveType;
        int newX, newY;

        // Perform the movement according to the randomly defined type.
        
        do {
            // Randomly select the type of movement: 0 for upper left, 
            // 1 for upper right, 2 for lower left, 3 for lower right
            moveType = random.nextInt(4);

            // Calculate the new coordinates according to the type of movement
            if (moveType == 0) {
                newX = 0;
                newY = 0;
            } else if (moveType == 1) {
                newX = 11;
                newY = 0;
            } else if (moveType == 2) {
                newX = 0;
                newY = 11;
            } else {
                newX = 11;
                newY = 11;
            }
        } while ((newX == xPosition && newY == yPosition) || !checkLocationAvailable(newX, newY)); 
        //do-While executes the code inside the "do".
        //and determine another movement if the coordinates are the same 
        //or if the target position is occupied, by using "while" and its 
        //conditions.
        
        

        // Updates the position
        setPosition(newX, newY);
        viewRobot();
    }
}