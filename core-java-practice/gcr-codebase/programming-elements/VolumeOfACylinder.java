import java.util.*;

public class VolumeOfACylinder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//taking radius of cylinder as input 
		System.out.println("Enter radius of cylinder(in units): ");
		double radiusOfCylinder = sc.nextDouble();
		
		//taking height of cylinder as input 
		System.out.println("Enter height of cylinder(in units): ");
		double heightOfCylinder = sc.nextDouble();
		
		//calculating volume using radius and height
		double volumeOfCylinder = Math.PI * Math.pow(radiusOfCylinder, 2) * heightOfCylinder;
		
		//printing volume on screen
		System.out.println("Calculated volume of cylinder(in units) is: " + volumeOfCylinder);
	}
}
