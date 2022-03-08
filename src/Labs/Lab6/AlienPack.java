package Labs.Lab6;

import java.util.ArrayList;

public class AlienPack {
    private ArrayList<Alien> aliens;

    public AlienPack (int numAliens) {
        aliens = new ArrayList<>(numAliens);
    }

    public void addAlien(Alien newAlien, int index) {
        aliens.add(index, newAlien);
    }

    public void addAlien(Alien newAlien) {
        aliens.add(newAlien);
    }

    public ArrayList<Alien> getAliens() {
        return aliens;
    }

    public int calculateDamage() {
        int damage = 0;
        for (Alien alien : aliens) {
            if (alien == null) continue;

            if (alien instanceof SnakeAlien) {
                damage += SnakeAlien.getDamage(); // Snake does 10 damage
            } else if (alien instanceof OgreAlien) {
                damage += OgreAlien.getDamage(); // Ogre does 6 damage
            } else if (alien instanceof MarshmallowAlien) {
                damage += MarshmallowAlien.getDamage(); // Marshmallow Man does 1 damage
            }
        }
        return damage;
    }
}