package gcr_codebase.linked_list;

import java.util.Scanner;

//Node representing a process
class ProcessNode {
 int pid;
 int burstTime;
 int remainingTime;
 int priority;
 int waitingTime;
 int turnaroundTime;
 ProcessNode next;

 ProcessNode(int pid, int burstTime, int priority) {
     this.pid = pid;
     this.burstTime = burstTime;
     this.remainingTime = burstTime;
     this.priority = priority;
     this.next = null;
 }
}

//Circular Linked List for Round Robin Scheduling
class RoundRobinScheduler {
 private ProcessNode head = null;
 private ProcessNode tail = null;
 private int processCount = 0;

 // Add process at end
 void addProcess(int pid, int burstTime, int priority) {
     ProcessNode newNode = new ProcessNode(pid, burstTime, priority);

     if (head == null) {
         head = tail = newNode;
         newNode.next = head;
     } else {
         tail.next = newNode;
         tail = newNode;
         tail.next = head;
     }
     processCount++;
 }

 // Remove process by ID
 void removeProcess(int pid) {
     if (head == null)
         return;

     ProcessNode curr = head;
     ProcessNode prev = tail;

     do {
         if (curr.pid == pid) {
             if (curr == head && curr == tail) {
                 head = tail = null;
             } else {
                 prev.next = curr.next;
                 if (curr == head)
                     head = curr.next;
                 if (curr == tail)
                     tail = prev;
             }
             processCount--;
             return;
         }
         prev = curr;
         curr = curr.next;
     } while (curr != head);
 }

 // Display circular queue
 void displayQueue() {
     if (head == null) {
         System.out.println("Queue is empty");
         return;
     }

     ProcessNode temp = head;
     System.out.print("Processes: ");
     do {
         System.out.print("[PID " + temp.pid +
                 " | Remaining " + temp.remainingTime + "] -> ");
         temp = temp.next;
     } while (temp != head);
     System.out.println("(back to head)");
 }

 // Round Robin Scheduling Simulation
 void simulate(int timeQuantum) {
     if (head == null) {
         System.out.println("No processes to schedule");
         return;
     }

     int time = 0;
     ProcessNode curr = head;

     System.out.println("\nStarting Round Robin Scheduling\n");

     while (processCount > 0) {

         if (curr.remainingTime > 0) {
             System.out.println("Executing Process PID " + curr.pid);

             if (curr.remainingTime > timeQuantum) {
                 time += timeQuantum;
                 curr.remainingTime -= timeQuantum;
             } else {
                 time += curr.remainingTime;
                 curr.remainingTime = 0;
                 curr.turnaroundTime = time;
                 curr.waitingTime = curr.turnaroundTime - curr.burstTime;

                 int completedPid = curr.pid;
                 curr = curr.next;
                 removeProcess(completedPid);
                 displayQueue();
                 continue;
             }
             displayQueue();
         }
         curr = curr.next;
     }

     calculateAverageTimes();
 }

 // Calculate average waiting and turnaround time
 void calculateAverageTimes() {
     Scanner sc = new Scanner(System.in);
     System.out.print("\nEnter number of processes for final calculation: ");
     int n = sc.nextInt();

     int totalWT = 0, totalTAT = 0;

     for (int i = 1; i <= n; i++) {
         System.out.print("Enter Waiting Time of PID " + i + ": ");
         totalWT += sc.nextInt();
         System.out.print("Enter Turnaround Time of PID " + i + ": ");
         totalTAT += sc.nextInt();
     }

     System.out.println("\nAverage Waiting Time: " + (double) totalWT / n);
     System.out.println("Average Turnaround Time: " + (double) totalTAT / n);
 }
}

//Main class
public class RoundRobinScheduling {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     RoundRobinScheduler scheduler = new RoundRobinScheduler();

     while (true) {
         System.out.println("\nRound Robin Menu");
         System.out.println("1 Add Process");
         System.out.println("2 Display Process Queue");
         System.out.println("3 Simulate Scheduling");
         System.out.println("0 Exit");
         System.out.print("Enter choice: ");

         int choice = sc.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Process ID: ");
                 int pid = sc.nextInt();
                 System.out.print("Burst Time: ");
                 int bt = sc.nextInt();
                 System.out.print("Priority: ");
                 int pr = sc.nextInt();
                 scheduler.addProcess(pid, bt, pr);
                 break;

             case 2:
                 scheduler.displayQueue();
                 break;

             case 3:
                 System.out.print("Enter Time Quantum: ");
                 int tq = sc.nextInt();
                 scheduler.simulate(tq);
                 break;

             case 0:
                 System.out.println("Exiting program");
                 sc.close();
                 return;

             default:
                 System.out.println("Invalid choice");
         }
     }
 }
}
