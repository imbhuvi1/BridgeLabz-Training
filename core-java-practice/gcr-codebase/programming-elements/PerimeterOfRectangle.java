
import java.util.*;
public class PerimeterOfRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking length as width as input
		System.out.println("Enter length of rectangle: ");
		double lengthOfRectangle = sc.nextDouble();
		
		System.out.println("Enter width of rectangle: ");
		double widthOfRectangle = sc.nextDouble();
		
		//calculating perimeter of rectangle 
		double perimeterOfRectangle = lengthOfRectangle + widthOfRectangle;
		
		//printing perimeter of rectangle on screen
		System.out.println("Calculated perimeter of rectangle: "+ perimeterOfRectangle);
	}

}
