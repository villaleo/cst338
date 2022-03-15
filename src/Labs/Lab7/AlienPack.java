package Labs.Lab7;

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
        for (var alien : aliens) {
            damage += alien.getDamage();
        }
        return damage;
    }
}
