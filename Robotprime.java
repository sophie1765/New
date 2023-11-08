/**
 * Robot se deplace à la diagonale et qui ne touche pas les autres robots 
 * version 3
 * @Greg pineau 
 * 
 */public class Robotprime extends Robot {
    private int directionX = 1;
    private int directionY = 1;
    private int canvasWidth = 12;
    private int canvasHeight = 12;
    private WorldOfRobot world;

    public Robotprime(String nameRobot, int x, int y, WorldOfRobot world) {
        super(nameRobot, x, y, world);
        this.world = world;
    }

    @Override
    public void move() {
        int newX = getX() + directionX;
        int newY = getY() + directionY;
        
        viewRobot();
        if (newX < 0) {
            newX = 0;
            directionX = 1;
        } else if (newX >= canvasWidth) {
            newX = canvasWidth - 1;
            directionX = -1;
        }

        if (newY < 0) {
            newY = 0;
            directionY = 1;
        } else if (newY >= canvasHeight) {
            newY = canvasHeight - 1;
            directionY = -1;
        }

        if (!checkCollisionWithOtherRobots(newX, newY)) {
            setPosition(newX, newY);
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
}