package scenario_based.TrafficManager;

// Queue for vehicles waiting to enter roundabout
public class WaitingQueue {

    private String[] queue;
    private int front, rear, size, capacity;

    public WaitingQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = rear = size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(String vehicle) {
        if (isFull()) {
            System.out.println("Queue Overflow! Vehicle cannot enter.");
            return;
        }
        queue[rear] = vehicle;
        rear = (rear + 1) % capacity;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! No vehicle waiting.");
            return null;
        }
        String v = queue[front];
        front = (front + 1) % capacity;
        size--;
        return v;
    }
}
