
import java.util.*;
public class SpringSeason {

	
	public static void checkSpring(int day, int month) {
		if(month==3) {
			if(day>=20 || day<=31) {
				System.out.println("It's a Spring Season");
			}
		}else if(month==4) {
			if(day>=1 || day<=30) {
				System.out.println("It's a Spring Season");
			}
		}else if(month==5) {
			if(day>=1 || day<=31) {
				System.out.println("It's a Spring Season");
			}
		}else if(month==6) {
			if(day>=1 || day<=30) {
				System.out.println("It's a Spring Season");
			}
		}else {
			System.out.println("Not a Spring Season");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//take input month and day
		System.out.println("Enter the day(1-31): ");
		int day = sc.nextInt();
		
		System.out.println("Enter the month(1-12): ");
		int month = sc.nextInt();
		
		//calling checkSpringSeason function and displaying the result
		checkSpring(day, month);
		
		sc.close();
	}

}
