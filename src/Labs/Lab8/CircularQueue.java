package Labs.Lab8;

import java.util.Arrays;

// This class is incomplete
public class CircularQueue implements InterCharQ {
    private final char[] queue;
    int putLoc, getLoc;

    public CircularQueue(int capacity) {
        queue = new char[capacity];
        putLoc = getLoc = 0;
    }

    @Override
    public void put(char ch) {
        queue[putLoc++ % queue.length] = ch;
    }

    @Override
    public char get() {
        return queue[getLoc++ % queue.length];
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
