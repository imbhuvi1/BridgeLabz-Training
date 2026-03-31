/*
 * Two Sum Problem
 * Problem: Given an array and a target sum, find two indices such that their values add up to the target.
 * Hint: Use a hash map to store the index of each element as you iterate. Check if target - current_element exists in the map.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;
import java.util.*;

public class TwoSum {

    public static void twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];

            if (map.containsKey(required)) {
                System.out.println("Indices: "
                        + map.get(required) + " and " + i);
                return;
            }
            map.put(arr[i], i);
        }

        System.out.println("No solution found");
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

        twoSum(arr, target);
        sc.close();
    }
}

