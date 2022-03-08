package Labs.Lab6;

public class OgreAlien extends Alien {
    public static final int DAMAGE = 6;
    public OgreAlien(int health, String name) {
        super(health, name);
    }

    public static int getDamage() {
        return DAMAGE;
    }
}
