
import java.util.*;

public class MatrixOperations2 {

    //Generate random matrix with given rows and columns
    public static double[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // random integers 0 to 9 for simplicity
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    //Transpose of a matrix
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    //Determinant of 2x2 matrix
    public static double determinant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    //Determinant of 3x3 matrix
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    //Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) {
            throw new ArithmeticException("Matrix is singular, can't find inverse");
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        return inverse;
    }

    //Inverse of 3x3 matrix using adjoint and determinant
    public static double[][] inverse3x3(double[][] matrix) {
        double det = determinant3x3(matrix);
        if (det == 0) {
            throw new ArithmeticException("Matrix is singular, can't find inverse");
        }

        double[][] adj = new double[3][3];

        //Calculate cofactor matrix (adjoint is transpose of cofactor matrix)
        adj[0][0] =  determinant2x2(new double[][] {{matrix[1][1], matrix[1][2]}, {matrix[2][1], matrix[2][2]}});
        adj[0][1] = -determinant2x2(new double[][] {{matrix[1][0], matrix[1][2]}, {matrix[2][0], matrix[2][2]}});
        adj[0][2] =  determinant2x2(new double[][] {{matrix[1][0], matrix[1][1]}, {matrix[2][0], matrix[2][1]}});
        adj[1][0] = -determinant2x2(new double[][] {{matrix[0][1], matrix[0][2]}, {matrix[2][1], matrix[2][2]}});
        adj[1][1] =  determinant2x2(new double[][] {{matrix[0][0], matrix[0][2]}, {matrix[2][0], matrix[2][2]}});
        adj[1][2] = -determinant2x2(new double[][] {{matrix[0][0], matrix[0][1]}, {matrix[2][0], matrix[2][1]}});
        adj[2][0] =  determinant2x2(new double[][] {{matrix[0][1], matrix[0][2]}, {matrix[1][1], matrix[1][2]}});
        adj[2][1] = -determinant2x2(new double[][] {{matrix[0][0], matrix[0][2]}, {matrix[1][0], matrix[1][2]}});
        adj[2][2] =  determinant2x2(new double[][] {{matrix[0][0], matrix[0][1]}, {matrix[1][0], matrix[1][1]}});

        //Transpose the cofactor matrix to get adjoint
        adj = transpose(adj);

        //Divide each element by determinant to get inverse
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                adj[i][j] = adj[i][j] / det;
            }
        }
        return adj;
    }

    //Display matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.3f ", val);
            }
            System.out.println();
        }
    }

    //Main method
    public static void main(String[] args) {
        // Create a random 3x3 matrix
        double[][] matrix3x3 = createRandomMatrix(3, 3);
        System.out.println("Random 3x3 Matrix:");
        displayMatrix(matrix3x3);

        //Transpose
        System.out.println("\nTranspose of 3x3 Matrix:");
        double[][] transposed3x3 = transpose(matrix3x3);
        displayMatrix(transposed3x3);

        //Determinant 3x3
        double det3x3 = determinant3x3(matrix3x3);
        System.out.printf("\nDeterminant of 3x3 matrix: %.3f\n", det3x3);

        if (det3x3 != 0) {
            //Inverse 3x3
            System.out.println("\nInverse of 3x3 matrix:");
            double[][] inv3x3 = inverse3x3(matrix3x3);
            displayMatrix(inv3x3);
        } else {
            System.out.println("\nMatrix is singular, no inverse.");
        }

        //Create a random 2x2 matrix
        double[][] matrix2x2 = createRandomMatrix(2, 2);
        System.out.println("\nRandom 2x2 Matrix:");
        displayMatrix(matrix2x2);

        //Transpose
        System.out.println("\nTranspose of 2x2 Matrix:");
        double[][] transposed2x2 = transpose(matrix2x2);
        displayMatrix(transposed2x2);

        //Determinant 2x2
        double det2x2 = determinant2x2(matrix2x2);
        System.out.printf("\nDeterminant of 2x2 matrix: %.3f\n", det2x2);

        if (det2x2 != 0) {
            //Inverse 2x2
            System.out.println("\nInverse of 2x2 matrix:");
            double[][] inv2x2 = inverse2x2(matrix2x2);
            displayMatrix(inv2x2);
        } else {
            System.out.println("\nMatrix is singular, no inverse.");
        }
    }
}

