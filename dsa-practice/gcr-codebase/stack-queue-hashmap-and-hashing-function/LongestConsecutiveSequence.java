/*
 * Longest Consecutive Sequence
 * Problem: Given an unsorted array, find the length of the longest consecutive elements sequence.
 * Hint: Use a hash map to store elements and check for consecutive elements efficiently.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int longest = 0;

        for (int num : set) {
            // Start only if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;
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

        System.out.println("Longest consecutive sequence length: "
                + longestSequence(arr));

        sc.close();
    }
}
