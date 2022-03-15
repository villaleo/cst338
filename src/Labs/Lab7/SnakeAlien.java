package Labs.Lab7;

public class SnakeAlien extends Alien {
    public static final int DAMAGE = 10;
    public SnakeAlien(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }
}
