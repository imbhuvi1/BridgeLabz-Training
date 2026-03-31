/*
 * Sort a Stack Using Recursion
 * Problem: Given a stack, sort its elements in ascending order using recursion.
 * Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.Scanner;
import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {

        // Base case: stack is empty
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Remove the top element
        int top = stack.pop();

        // Step 2: Sort the remaining stack
        sortStack(stack);

        // Step 3: Insert the popped element at correct position
        insertAtCorrectPosition(stack, top);
    }

    // Function to insert an element into sorted stack
    private static void insertAtCorrectPosition(Stack<Integer> stack, int element) {

        // Base case:
        // If stack is empty OR element is greater than top element
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Recursively find correct position
        insertAtCorrectPosition(stack, element);

        // Push the removed element back
        stack.push(top);
    }

    // Main method with user input
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Original Stack: " + stack);

        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack (Ascending): " + stack);

        sc.close();
    }
}
