/*
 * Sliding Window Maximum
 * Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
 * Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.*;

public class SlidingWindowMaximum {

    public static void findMaxInWindows(int[] arr, int n, int k) {

        Deque<Integer> deque = new LinkedList<>();

        // Process first window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process remaining elements
        for (int i = k; i < n; i++) {
            System.out.print(arr[deque.peek()] + " ");

            // Remove elements outside window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Print max of last window
        System.out.print(arr[deque.peek()]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size: ");
        int k = sc.nextInt();

        System.out.println("Sliding Window Maximums:");
        findMaxInWindows(arr, n, k);

        sc.close();
    }
}
