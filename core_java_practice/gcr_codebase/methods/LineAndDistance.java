package gcr_codebase.methods;

import java.util.Scanner;

public class LineAndDistance {

    //Method to find Euclidean distance between two points
    public static double findDistance(double x1, double y1, double x2, double y2) {

        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    //Method to find slope and y-intercept of a line
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {

        double[] result = new double[2];
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);

        result[0] = m; 
        result[1] = b; 

        return result;
    }

    //Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Taking input for first point
        System.out.print("enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("enter y1: ");
        double y1 = sc.nextDouble();

        //Taking input for second point
        System.out.print("enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("enter y2: ");
        double y2 = sc.nextDouble();

        //Calling distance method
        double distance = findDistance(x1, y1, x2, y2);

        //Calling line equation method
        double[] line = findLineEquation(x1, y1, x2, y2);

        //Displaying results
        System.out.println("euclidean distance = " + distance);
        System.out.println("equation of line: y = " + line[0] + "x + " + line[1]);

        sc.close();
    }
}
