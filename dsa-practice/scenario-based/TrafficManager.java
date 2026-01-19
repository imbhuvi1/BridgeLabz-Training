import java.util.LinkedList;
import java.util.Queue;

// Vehicle Node for Circular Linked List
class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

// Circular Linked List for Roundabout
class Roundabout {
    private Vehicle tail = null;

    // Add vehicle to roundabout
    public void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);

        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }
        System.out.println("Vehicle " + number + " entered roundabout.");
    }

    // Remove vehicle from roundabout
    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            System.out.println("Vehicle " + head.number + " exited roundabout.");
            tail = null;
        } else {
            System.out.println("Vehicle " + head.number + " exited roundabout.");
            tail.next = head.next;
        }
    }

    // Print current state
    public void printState() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle temp = tail.next;
        System.out.print("Roundabout: ");

        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("(circular)");
    }
}

// Queue Manager
class VehicleQueue {
    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(String vehicle) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! Vehicle " + vehicle + " cannot enter.");
            return;
        }
        queue.add(vehicle);
        System.out.println("Vehicle " + vehicle + " added to waiting queue.");
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }
}

// Main Class
public class TrafficManager {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(3);

        queue.enqueue("CAR-101");
        queue.enqueue("CAR-102");
        queue.enqueue("CAR-103");
        queue.enqueue("CAR-104"); // Overflow

        String v;
        while ((v = queue.dequeue()) != null) {
            roundabout.addVehicle(v);
        }

        roundabout.printState();
        roundabout.removeVehicle();
        roundabout.printState();
    }
}
