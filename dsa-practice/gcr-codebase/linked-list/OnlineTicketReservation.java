import java.util.Scanner;

//Node representing a ticket
class TicketNode {
 int ticketId;
 String customerName;
 String movieName;
 String seatNumber;
 String bookingTime;
 TicketNode next;

 TicketNode(int ticketId, String customerName, String movieName,
            String seatNumber, String bookingTime) {
     this.ticketId = ticketId;
     this.customerName = customerName;
     this.movieName = movieName;
     this.seatNumber = seatNumber;
     this.bookingTime = bookingTime;
     this.next = null;
 }
}

//Circular Linked List for Ticket Reservation
class TicketReservationSystem {
 private TicketNode head = null;
 private TicketNode tail = null;
 private int count = 0;

 // Add ticket at end
 void addTicket(int id, String customer, String movie,
                String seat, String time) {

     TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

     if (head == null) {
         head = tail = newNode;
         newNode.next = head;
     } else {
         tail.next = newNode;
         tail = newNode;
         tail.next = head;
     }
     count++;
     System.out.println("Ticket booked successfully");
 }

 // Remove ticket by Ticket ID
 void removeTicket(int id) {
     if (head == null) {
         System.out.println("No tickets booked");
         return;
     }

     TicketNode curr = head;
     TicketNode prev = tail;

     do {
         if (curr.ticketId == id) {

             if (curr == head && curr == tail) {
                 head = tail = null;
             } else {
                 prev.next = curr.next;
                 if (curr == head)
                     head = curr.next;
                 if (curr == tail)
                     tail = prev;
             }

             count--;
             System.out.println("Ticket cancelled successfully");
             return;
         }
         prev = curr;
         curr = curr.next;

     } while (curr != head);

     System.out.println("Ticket not found");
 }

 // Display all tickets
 void displayTickets() {
     if (head == null) {
         System.out.println("No tickets booked");
         return;
     }

     TicketNode temp = head;
     System.out.println("\nBooked Tickets:");
     do {
         displayTicket(temp);
         temp = temp.next;
     } while (temp != head);
 }

 // Search by customer name
 void searchByCustomer(String name) {
     if (head == null) {
         System.out.println("No tickets booked");
         return;
     }

     TicketNode temp = head;
     boolean found = false;

     do {
         if (temp.customerName.equalsIgnoreCase(name)) {
             displayTicket(temp);
             found = true;
         }
         temp = temp.next;
     } while (temp != head);

     if (!found)
         System.out.println("No ticket found for this customer");
 }

 // Search by movie name
 void searchByMovie(String movie) {
     if (head == null) {
         System.out.println("No tickets booked");
         return;
     }

     TicketNode temp = head;
     boolean found = false;

     do {
         if (temp.movieName.equalsIgnoreCase(movie)) {
             displayTicket(temp);
             found = true;
         }
         temp = temp.next;
     } while (temp != head);

     if (!found)
         System.out.println("No ticket found for this movie");
 }

 // Display single ticket
 void displayTicket(TicketNode t) {
     System.out.println("Ticket ID: " + t.ticketId);
     System.out.println("Customer: " + t.customerName);
     System.out.println("Movie: " + t.movieName);
     System.out.println("Seat: " + t.seatNumber);
     System.out.println("Time: " + t.bookingTime);
     System.out.println("---------------------------");
 }

 // Total booked tickets
 void totalTickets() {
     System.out.println("Total Booked Tickets: " + count);
 }
}

//Main class
public class OnlineTicketReservation {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     TicketReservationSystem system = new TicketReservationSystem();

     while (true) {
         System.out.println("\nTicket Reservation Menu");
         System.out.println("1 Book Ticket");
         System.out.println("2 Cancel Ticket");
         System.out.println("3 Display All Tickets");
         System.out.println("4 Search Ticket");
         System.out.println("5 Total Booked Tickets");
         System.out.println("0 Exit");
         System.out.print("Enter choice: ");

         int choice = sc.nextInt();
         sc.nextLine();

         switch (choice) {
             case 1:
                 System.out.print("Ticket ID: ");
                 int id = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Customer Name: ");
                 String cust = sc.nextLine();
                 System.out.print("Movie Name: ");
                 String movie = sc.nextLine();
                 System.out.print("Seat Number: ");
                 String seat = sc.nextLine();
                 System.out.print("Booking Time: ");
                 String time = sc.nextLine();

                 system.addTicket(id, cust, movie, seat, time);
                 break;

             case 2:
                 System.out.print("Enter Ticket ID to cancel: ");
                 system.removeTicket(sc.nextInt());
                 break;

             case 3:
                 system.displayTickets();
                 break;

             case 4:
                 System.out.print("1 Search by Customer  2 Search by Movie: ");
                 int s = sc.nextInt();
                 sc.nextLine();
                 if (s == 1) {
                     System.out.print("Enter Customer Name: ");
                     system.searchByCustomer(sc.nextLine());
                 } else {
                     System.out.print("Enter Movie Name: ");
                     system.searchByMovie(sc.nextLine());
                 }
                 break;

             case 5:
                 system.totalTickets();
                 break;

             case 0:
                 System.out.println("Exiting system");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice");
         }
     }
 }
}
