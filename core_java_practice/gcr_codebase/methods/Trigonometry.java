package gcr_codebase.methods;

import java.util.*;

public class Trigonometry {

    // Method to calculate trigonometric functions
    public static double[] calculateTrigonometricFunctions(double angle) {
    	//converting angle (degrees to radians)
        double radians = Math.toRadians(angle);
        
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking input
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        //calling method
        double[] result = calculateTrigonometricFunctions(angle);

        //Displaying result
        System.out.println("Sine = " + result[0]);
        System.out.println("Cosine = " + result[1]);
        System.out.println("Tangent = " + result[2]);

        sc.close();
    }
}

