import java.util.Random;

public class RandomSpeedRobot extends Robot {
    private int direction; // 1 pour aller vers la droite, -1 pour revenir vers la gauche
    private int distance; // Distance totale à parcourir
    private int currentPosition; // Position actuelle du robot
    private Random random; // Générateur de nombres aléatoires

    public RandomSpeedRobot(String nameRobot, int x, int y, WorldOfRobot wor) {
        super(nameRobot, 0, 8, wor);
        this.direction = 1; // Commence par aller vers la droite
        this.distance = 11;
        this.currentPosition = x;
        this.random = new Random();
        wor.addRobot(this);
    }

    public void move() {
        int speed = random.nextInt(3); // Génère une vitesse aléatoire entre 1 et 3

        if (speed == 1) {
            super.setColourBody("red");
        } else if (speed == 2) {
            super.setColourBody("yellow");
        } else {
            super.setColourBody("green");
        }

        if (direction == 1) {
            // Si la direction est de 1, le robot se déplace vers la droite
            int newX = currentPosition + speed;

            if (newX + distance <= 22 && checkLocationAvailable(newX, getY())) {
                currentPosition = newX;
                setPosition(newX, getY());
            } else {
                // Si la distance à parcourir est atteinte ou qu'il y a une collision, change la direction pour revenir
                direction = -1;
            }
            viewRobot();
        } else if (direction == -1) {
            // Si la direction est de -1, le robot se déplace vers la gauche
            int newX = currentPosition - speed;

            if (newX >= 0 && checkLocationAvailable(newX, getY())) {
                currentPosition = newX;
                setPosition(newX, getY());
            } else {
                // Si le robot est revenu à son point de départ ou qu'il y a une collision, change la direction pour aller à nouveau vers la droite
                direction = 1;
            }
            viewRobot();
        }
    }
}