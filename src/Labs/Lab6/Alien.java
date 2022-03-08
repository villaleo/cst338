package Labs.Lab6;

public class Alien {
    private int health; // 0=dead, 100=full strength
    private String name;

    public Alien(int health, String name) {
        setHealth(health);
        setName(name);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}