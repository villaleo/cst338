package Labs.Lab6;

public class SnakeAlien extends Alien {
    public static final int DAMAGE = 10;
    public SnakeAlien(int health, String name) {
        super(health, name);
    }

    public static int getDamage() {
        return DAMAGE;
    }
}
