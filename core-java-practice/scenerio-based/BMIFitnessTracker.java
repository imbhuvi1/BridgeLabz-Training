
import java.util.*;
public class BMIFitnessTracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//asking user to input height and weight
		System.out.println("Enter height in meteres: ");
		double height = sc.nextDouble();
		
		System.out.println("Enter weight in kilogram: ");
		double weight = sc.nextDouble();
		
		//calculating the BMI of the client
		double BMI = weight / (height*height);
		
		//predicting the overweight, under weight and normal BMI of client
		if(BMI<18.5) {
			System.out.println("Client is 'underweight', with BMI of: "+BMI);
		}else if(BMI>18.5 && BMI<24.9) {
			System.out.println("Client is 'normal/healthy', with BMI of: "+BMI);
		}else {
			System.out.println("Client is 'overweight', with BMI of: "+BMI);
		}
	}

}
