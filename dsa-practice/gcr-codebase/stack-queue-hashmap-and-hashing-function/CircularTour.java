/*
 * Circular Tour Problem
 * Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.
 * Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.Scanner;

public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance, int n) {

        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];

            // If surplus becomes negative, change start
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }

        // Check if tour is possible
        if (surplus + deficit >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.println("Enter distance to next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        int start = findStartingPoint(petrol, distance, n);

        if (start == -1) {
            System.out.println("No possible circular tour");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }

        sc.close();
    }
}
