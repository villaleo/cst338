package Labs.Lab7;

public class AlienDemo {
    public static void main(String[] args) {
        var brutus = new OgreAlien(100,"brutus");
        var slimy = new SnakeAlien(100,"slimy");
        var puffy = new MarshmallowAlien(100,"puffy");

        var pack = new AlienPack(3); // 3 aliens in the pack
        pack.addAlien(brutus);
        pack.addAlien(slimy);
        pack.addAlien(puffy);

        System.out.printf("Total pack damage = %d", pack.calculateDamage());
    }
}
