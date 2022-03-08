package Labs.Lab6;

public class MarshmallowAlien extends Alien {
    public static final int DAMAGE = 1;
    public MarshmallowAlien(int health, String name) {
        super(health, name);
    }

    public static int getDamage() {
        return DAMAGE;
    }
}
