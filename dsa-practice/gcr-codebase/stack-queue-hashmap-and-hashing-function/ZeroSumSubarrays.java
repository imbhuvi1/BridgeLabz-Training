/*
 * Find All Subarrays with Zero Sum
 * Problem: Given an array, find all subarrays whose elements sum up to zero.
 * Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.*;

public class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        // sum 0 at index -1 (for subarrays starting from index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println("Zero sum subarray from index "
                            + (startIndex + 1) + " to " + i);
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
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

        findZeroSumSubarrays(arr);
        sc.close();
    }
}
