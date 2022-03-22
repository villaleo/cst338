package Labs.Lab8;

public class DynamicQ implements InterCharQ {
    private char[] queue;
    private int front, back;

    public DynamicQ(int size) {
        queue = new char[size];
        front = back = 0;
    }

    @Override
    public void put(char ch) {
        if (back == queue.length) {
            char[] newArray = new char[queue.length * 2];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back++] = ch;
    }

    @Override
    public char get() {
        return queue[front++];
    }
}
