package gcr_codebase.sorting_algorithms;

import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from second element
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] empIds = new int[n];

        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = sc.nextInt();
        }

        insertionSort(empIds);

        System.out.println("Sorted employee IDs:");
        for (int id : empIds) {
            System.out.print(id + " ");
        }
    }
}

