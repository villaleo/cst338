package Labs.Lab7;

public class OgreAlien extends Alien {
    public static final int DAMAGE = 6;
    public OgreAlien(int health, String name) {
        super(health, name);
    }

    @Override
    public int getDamage() {
        return DAMAGE;
    }
}
