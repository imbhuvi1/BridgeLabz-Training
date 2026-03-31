/*
 * Implement a Queue Using Stacks
 * Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
 * Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {

    // Stack used for enqueue operation
    private Stack<Integer> stackEnq = new Stack<>();

    // Stack used for dequeue operation
    private Stack<Integer> stackDeq = new Stack<>();

    // Enqueue operation
    public void enqueue(int data) {
        stackEnq.push(data);
        System.out.println(data + " enqueued successfully");
    }

    // Dequeue operation
    public void dequeue() {
        // If both stacks are empty, queue is empty
        if (stackEnq.isEmpty() && stackDeq.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        // Transfer elements only if dequeue stack is empty
        if (stackDeq.isEmpty()) {
            while (!stackEnq.isEmpty()) {
                stackDeq.push(stackEnq.pop());
            }
        }

        int removed = stackDeq.pop();
        System.out.println("Dequeued element: " + removed);
    }

    // Display queue elements
    public void display() {
        if (stackEnq.isEmpty() && stackDeq.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");

        // Print elements from dequeue stack
        for (int i = stackDeq.size() - 1; i >= 0; i--) {
            System.out.print(stackDeq.get(i) + " ");
        }

        // Print elements from enqueue stack
        for (int i = 0; i < stackEnq.size(); i++) {
            System.out.print(stackEnq.get(i) + " ");
        }

        System.out.println();
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks();
        int choice;

        do {
            System.out.println("\nQueue Using Two Stacks");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
