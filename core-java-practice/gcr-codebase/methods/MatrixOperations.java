package gcr_codebase.methods;

import java.util.*;

public class MatrixOperations {

    //Method to create a random matrix of size rows x cols
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    //Method to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    //Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    //Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    //Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rowsA = 3, colsA = 2;
        int rowsB = 2, colsB = 3;

        // Create random matrices A and B
        int[][] A = createRandomMatrix(rowsA, colsA);
        int[][] B = createRandomMatrix(rowsB, colsB);

        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("\nMatrix B:");
        printMatrix(B);

        //Addition and subtraction require matrices of the same size, so creating two random matrices with the same dimensions for these operations
        int[][] C = createRandomMatrix(3, 3);
        int[][] D = createRandomMatrix(3, 3);

        System.out.println("\nMatrix C:");
        printMatrix(C);

        System.out.println("\nMatrix D:");
        printMatrix(D);

        System.out.println("\nC + D:");
        printMatrix(addMatrices(C, D));

        System.out.println("\nC - D:");
        printMatrix(subtractMatrices(C, D));

        System.out.println("\nA * B:");
        printMatrix(multiplyMatrices(A, B));
    }
}

