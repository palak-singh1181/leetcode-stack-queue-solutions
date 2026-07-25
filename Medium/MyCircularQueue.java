public class MyCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // ==========================
    // Main Method for VS Code
    // ==========================
    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println("enQueue(1): " + q.enQueue(1));
        System.out.println("enQueue(2): " + q.enQueue(2));
        System.out.println("enQueue(3): " + q.enQueue(3));
        System.out.println("enQueue(4): " + q.enQueue(4));

        System.out.println("Rear(): " + q.Rear());
        System.out.println("isFull(): " + q.isFull());

        System.out.println("deQueue(): " + q.deQueue());

        System.out.println("enQueue(4): " + q.enQueue(4));

        System.out.println("Rear(): " + q.Rear());
        System.out.println("Front(): " + q.Front());

        System.out.println("isEmpty(): " + q.isEmpty());
    }
}