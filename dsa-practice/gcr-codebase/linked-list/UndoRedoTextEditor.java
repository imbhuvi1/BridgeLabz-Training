

import java.util.Scanner;

//Node representing a text state
class TextState {
 String content;
 TextState prev;
 TextState next;

 TextState(String content) {
     this.content = content;
     this.prev = null;
     this.next = null;
 }
}

//Doubly Linked List for Undo Redo
class TextEditorHistory {
 private TextState head = null;
 private TextState tail = null;
 private TextState current = null;
 private int size = 0;
 private final int MAX_HISTORY = 10;

 // Add new text state
 void addState(String text) {
     TextState newNode = new TextState(text);

     // Remove redo history
     if (current != null && current.next != null) {
         current.next.prev = null;
         current.next = null;
         tail = current;
         size = calculateSize();
     }

     if (head == null) {
         head = tail = current = newNode;
     } else {
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
         current = newNode;
     }

     size++;

     // Limit history size
     if (size > MAX_HISTORY) {
         head = head.next;
         head.prev = null;
         size--;
     }
 }

 // Undo operation
 void undo() {
     if (current == null || current.prev == null) {
         System.out.println("Nothing to undo");
         return;
     }
     current = current.prev;
     System.out.println("Undo successful");
 }

 // Redo operation
 void redo() {
     if (current == null || current.next == null) {
         System.out.println("Nothing to redo");
         return;
     }
     current = current.next;
     System.out.println("Redo successful");
 }

 // Display current text
 void displayCurrent() {
     if (current == null) {
         System.out.println("Editor is empty");
     } else {
         System.out.println("Current Text: " + current.content);
     }
 }

 // Display full history
 void displayHistory() {
     if (head == null) {
         System.out.println("No history available");
         return;
     }

     TextState temp = head;
     System.out.println("Text History:");
     while (temp != null) {
         if (temp == current)
             System.out.println("-> " + temp.content + " (current)");
         else
             System.out.println("   " + temp.content);
         temp = temp.next;
     }
 }

 // Recalculate size after trimming redo states
 private int calculateSize() {
     int count = 0;
     TextState temp = head;
     while (temp != null) {
         count++;
         temp = temp.next;
     }
     return count;
 }
}

//Main class
public class UndoRedoTextEditor {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     TextEditorHistory editor = new TextEditorHistory();

     while (true) {
         System.out.println("\nText Editor Menu");
         System.out.println("1 Type Text");
         System.out.println("2 Undo");
         System.out.println("3 Redo");
         System.out.println("4 Display Current Text");
         System.out.println("5 Display History");
         System.out.println("0 Exit");
         System.out.print("Enter choice: ");

         int choice = sc.nextInt();
         sc.nextLine();

         switch (choice) {
             case 1:
                 System.out.print("Enter text: ");
                 String text = sc.nextLine();
                 editor.addState(text);
                 break;

             case 2:
                 editor.undo();
                 break;

             case 3:
                 editor.redo();
                 break;

             case 4:
                 editor.displayCurrent();
                 break;

             case 5:
                 editor.displayHistory();
                 break;

             case 0:
                 System.out.println("Exiting editor");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice");
         }
     }
 }
}

