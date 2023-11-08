import java.util.Random;
/**
 * this class allows the Lrobot robot to move by forming an L when moving
 * @author (Asmah)
 * @version (26/10/2023)
 */     

public class LRobot extends Robot {
    private int directionX = 1;
    private int directionY = 0;
    private int canvasWidth = 12;
    private int canvasHeight = 12;
    private WorldOfRobot world;
    //Constructeur

    public LRobot(String nameRobot, int x, int y, WorldOfRobot world) {
        super(nameRobot, x, y, world);
        this.world = world;
    }

    public void move() {
        int newX = getX() + directionX;
        int newY = getY() + directionY;

        viewRobot();

        if (newX >= 0 && newX < canvasWidth && newY >= 0 && newY < canvasHeight && !checkCollisionWithOtherRobots(newX, newY)) {
            // Déplacez le robot uniquement s'il n'y a pas de collision à la nouvelle position.
            setPosition(newX, newY);
        } else {
            // Changez de direction lorsque le robot rencontre un obstacle.
            changeDirection();
        }

        viewRobot();
    }

    private boolean checkCollisionWithOtherRobots(int x, int y) {
        for (Robot robot : world.getRobotList()) {
            if (robot != this && robot.getX() == x && robot.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private void changeDirection() {
        // Changez la direction du robot en fonction de sa direction actuelle.
        int tempDirectionX = directionX;
        directionX = -directionY;
        directionY = tempDirectionX;
    }
}