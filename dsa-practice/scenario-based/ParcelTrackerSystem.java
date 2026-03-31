import java.util.Scanner;

//Node of Singly Linked List
class ParcelStage {
 String stage;          // Stage name
 ParcelStage next;      // Pointer to next stage

 ParcelStage(String stage) {
     this.stage = stage;
     this.next = null;
 }
}

//Parcel Tracker using Singly Linked List
class ParcelTracker {
 private ParcelStage head;   // First stage

 // Add stage at the end
 public void addStage(String stage) {
     ParcelStage newNode = new ParcelStage(stage);

     if (head == null) {
         head = newNode;
         return;
     }

     ParcelStage temp = head;
     while (temp.next != null) {
         temp = temp.next;
     }
     temp.next = newNode;
 }

 // Add intermediate checkpoint after a given stage
 public void addCheckpoint(String afterStage, String newStage) {
     ParcelStage temp = head;

     while (temp != null && !temp.stage.equalsIgnoreCase(afterStage)) {
         temp = temp.next;
     }

     // Handle missing / lost parcel case
     if (temp == null) {
         System.out.println("Stage not found. Parcel may be lost.");
         return;
     }

     ParcelStage newNode = new ParcelStage(newStage);
     newNode.next = temp.next;
     temp.next = newNode;
 }

 // Forward tracking of parcel
 public void trackParcel() {
     if (head == null) {
         System.out.println("No parcel found (null pointer).");
         return;
     }

     ParcelStage temp = head;
     System.out.print("Parcel Status: ");

     while (temp != null) {
         System.out.print(temp.stage + " -> ");
         temp = temp.next;
     }
     System.out.println("END");
 }
}

//Main class
public class ParcelTrackerSystem {
 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     ParcelTracker tracker = new ParcelTracker();

     // Initial stages
     tracker.addStage("Packed");
     tracker.addStage("Shipped");
     tracker.addStage("In Transit");
     tracker.addStage("Delivered");

     // User choice to add checkpoint
     System.out.print("Do you want to add a checkpoint? (yes/no): ");
     String choice = sc.next();

     if (choice.equalsIgnoreCase("yes")) {
         System.out.print("Enter stage after which to add checkpoint: ");
         String afterStage = sc.next();

         sc.nextLine(); // clear buffer
         System.out.print("Enter new checkpoint name: ");
         String newStage = sc.nextLine();

         tracker.addCheckpoint(afterStage, newStage);
     }

     // Track parcel forward
     tracker.trackParcel();

     sc.close();
 }
}
