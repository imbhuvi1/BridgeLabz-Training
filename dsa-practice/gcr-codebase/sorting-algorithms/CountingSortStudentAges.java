package gcr_codebase.sorting_algorithms;

import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] arr, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];

        // Count frequency
        for (int age : arr) {
            count[age - minAge]++;
        }

        // Reconstruct sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + minAge;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages, 10, 18);

        System.out.println("Sorted student ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

