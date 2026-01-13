package scenario_based.TrafficManager;

// Circular Linked List for roundabout
public class Roundabout {

    private VehicleNode tail = null;

    // Add vehicle
    public void addVehicle(String vehicle) {
        VehicleNode newNode = new VehicleNode(vehicle);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove vehicle
    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }

    // Display state
    public void display() {
        if (tail == null) {
            System.out.println("Roundabout Empty");
            return;
        }

        VehicleNode temp = tail.next;
        do {
            System.out.print(temp.vehicleNumber + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("(back to start)");
    }
}
