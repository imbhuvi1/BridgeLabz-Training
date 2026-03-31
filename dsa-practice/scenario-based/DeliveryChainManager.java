package scenario_based;

//Node representing each delivery stage
class Stage {
 String status;      // Stage name
 Stage next;         // Pointer to next stage

 Stage(String status) {
     this.status = status;
     this.next = null;
 }
}

public class DeliveryChainManager {

 private Stage head; // Starting stage of the parcel

 // Add a stage at the end of the delivery chain
 public void addStage(String status) {
     Stage newStage = new Stage(status);

     if (head == null) {
         head = newStage;
         return;
     }

     Stage temp = head;
     while (temp.next != null) {
         temp = temp.next;
     }
     temp.next = newStage;
 }

 // Insert a custom checkpoint after a given stage
 public void addCheckpointAfter(String existingStage, String newCheckpoint) {
     Stage temp = head;

     while (temp != null && !temp.status.equals(existingStage)) {
         temp = temp.next;
     }

     if (temp == null) {
         System.out.println("Stage not found. Cannot add checkpoint.");
         return;
     }

     Stage checkpoint = new Stage(newCheckpoint);
     checkpoint.next = temp.next;
     temp.next = checkpoint;

     System.out.println("Checkpoint '" + newCheckpoint + "' added after '" + existingStage + "'");
 }

 // Track parcel from start to end
 public void trackParcel() {
     if (head == null) {
         System.out.println("Parcel tracking unavailable. Parcel might be lost.");
         return;
     }

     Stage temp = head;
     System.out.println("Parcel Tracking Status:");

     while (temp != null) {
         System.out.println("→ " + temp.status);
         temp = temp.next;
     }

     System.out.println("Delivery process completed.");
 }

 // Simulate parcel lost (break the chain)
 public void markParcelLostAfter(String stageName) {
     Stage temp = head;

     while (temp != null && !temp.status.equals(stageName)) {
         temp = temp.next;
     }

     if (temp != null) {
         temp.next = null; // Break the chain (null pointer scenario)
         System.out.println("Parcel lost after stage: " + stageName);
     } else {
         System.out.println("Stage not found.");
     }
 }

 public static void main(String[] args) {

     DeliveryChainManager manager = new DeliveryChainManager();

     // Initial delivery stages
     manager.addStage("Packed");
     manager.addStage("Shipped");
     manager.addStage("In Transit");
     manager.addStage("Delivered");

     // Add a custom checkpoint
     manager.addCheckpointAfter("Shipped", "Arrived at Local Hub");

     // Track parcel progress
     manager.trackParcel();

     // Simulate parcel getting lost after a stage
     manager.markParcelLostAfter("In Transit");

     System.out.println("\nTracking After Parcel Lost:");
     manager.trackParcel();
 }
}

