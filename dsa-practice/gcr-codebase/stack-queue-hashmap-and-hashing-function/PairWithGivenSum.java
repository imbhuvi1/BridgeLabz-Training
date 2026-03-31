/*
 * Check for a Pair with Given Sum in an Array
 * Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
 * Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: " + num + " + " + (target - num));
                return true;
            }
            set.add(num);
        }
        return false;
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

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (!hasPair(arr, target)) {
            System.out.println("No such pair exists");
        }

        sc.close();
    }
}

