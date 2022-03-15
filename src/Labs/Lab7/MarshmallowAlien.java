package Labs.Lab7;

public class MarshmallowAlien extends Alien {
    public static final int DAMAGE = 1;
    public MarshmallowAlien(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }
}
