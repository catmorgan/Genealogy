package utilities;

public class QueueArray implements Queue {

    private static final int INITIAL_SIZE = 10;
    private Object[] contents;
    private int front;
    private int back;

    public QueueArray() {
        contents = new Object[INITIAL_SIZE];
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return front == back;
    }

    public Object enQueue(Object item) {
        if ((back + 1) % contents.length == front) {
            expand();
        }
        contents[back] = item;
        back = (back + 1) % contents.length;
        return item;
    }

    public Object deQueue() {
        Object temp = contents[front];
        contents[front] = null;
        front = (front + 1) % contents.length;
        return temp;
    }

    public Object front() {
        return contents[front];
    }


    private void expand() {
        Object[] newContents = new Object[2 * contents.length];
        for (int i = 0; i < contents.length - 1; i++) {
            newContents[i] = contents[(front + i) % contents.length];
        }
        front = 0;
        back = contents.length - 1;
        contents = newContents;
    }
}

