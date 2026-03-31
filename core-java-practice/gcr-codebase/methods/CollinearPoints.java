
import java.util.Scanner;

public class CollinearPoints {

    // method to check Collinearity using slope formula
    public static boolean isCollinearBySlope(int x1, int y1,int x2, int y2,int x3, int y3) {

        //compare cross multiplication
        int slopeAB = (y2 - y1) * (x3 - x2);
        int slopeBC = (y3 - y2) * (x2 - x1);
        int slopeAC = (y3 - y1) * (x2 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    //Method to check collinearity using area of triangle formula
    public static boolean isCollinearByArea(int x1, int y1,int x2, int y2,int x3, int y3) {

        double area = 0.5 * (x1 * (y2 - y3)+ x2 * (y3 - y1)+ x3 * (y1 - y2));

        return area == 0;
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input
        System.out.print("Enter x1 y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        //Checking using slope method
        if (isCollinearBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using slope formula");
        } else {
            System.out.println("Points are not collinear using slope formula");
        }

        //Checking using area method
        if (isCollinearByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using area of triangle");
        } else {
            System.out.println("Points are not collinear using area of triangle");
        }

        sc.close();
    }
}

