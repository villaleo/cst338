package Labs.Lab8;

// This class is incomplete
public class CircularQ implements InterCharQ {
    private char[] queue;
    int front, back;
    int used;

    private boolean full() {
        return front == 0 && back == queue.length;
    }

    public CircularQ(int size) {
        queue = new char[size];
        front = 0;
        back = 0;
        used = 0;
    }

    @Override
    public void put(char ch) {
        if (full()) {
            System.out.printf("Unable to put `%c`: queue is full!\n", ch);
            return;
        }
        if (front == back) {
            // ...
        }
    }

    @Override
    public char get() {
        // ...
        return queue[front++];
    }
}
