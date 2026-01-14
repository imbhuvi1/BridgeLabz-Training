package gcr_codebase.sorting_algorithms;

import java.util.Scanner;

public class SelectionSortExamScores {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        selectionSort(scores);

        System.out.println("Sorted exam scores:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
