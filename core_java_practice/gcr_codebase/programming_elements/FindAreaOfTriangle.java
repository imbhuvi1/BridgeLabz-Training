package gcr_codebase.programming_elements;

import java.util.*;
public class FindAreaOfTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Taking base and height input from user in cm and creating two variables as baseOfTriangle and HeightOfTriangle and storing in them.
		System.out.println("Enter the base of the triangle: ");
		double baseOfTriangle = sc.nextDouble();
		
		System.out.println("Enter the height of the triangle: ");
		double heightOfTriangle = sc.nextDouble();
		
		//Calculating the area of the triangle and storing it inside a variable named areaOfThetriangle
		double areaOfTriangleInCm = 0.5 * baseOfTriangle * heightOfTriangle;
		
		//Calculating the area of the triangle in inches using the areaOfTriangleInCm value
		double areaOfTraingleInInches = (areaOfTriangleInCm)/(2.54*2.54);
		
		//Displaying the area of the triangle as mentioned in the question
		System.out.printf("The Area of the triangle in sq in is %s and sq cm is %s", areaOfTraingleInInches, areaOfTriangleInCm);
	}

}
