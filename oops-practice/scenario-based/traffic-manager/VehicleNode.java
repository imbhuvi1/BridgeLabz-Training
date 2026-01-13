package scenario_based.TrafficManager;

// Node for Circular Linked List
public class VehicleNode {

    String vehicleNumber;
    VehicleNode next;

    public VehicleNode(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.next = null;
    }
}
