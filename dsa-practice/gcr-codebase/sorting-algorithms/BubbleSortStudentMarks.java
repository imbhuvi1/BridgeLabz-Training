package gcr_codebase.sorting_algorithms;

import java.util.Scanner;

public class BubbleSortStudentMarks {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Traverse through the array multiple times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps happened, array is already sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        bubbleSort(marks);

        System.out.println("Sorted student marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}

