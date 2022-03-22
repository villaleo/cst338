package Labs.Lab8;

public class FixedCharQ implements InterCharQ {
    private char[] queue;
    private int putLoc;
    private int getLoc;

    public FixedCharQ(int size) {
        queue = new char[size];
        putLoc = getLoc = 0;
    }

    @Override
    public void put(char ch) {
        if (putLoc == queue.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        queue[putLoc++] = ch;
    }

    @Override
    public char get() {
        if (getLoc == putLoc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return queue[getLoc++];
    }
}
