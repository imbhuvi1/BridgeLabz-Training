package scenerio_based;

import java.util.Scanner;
import java.util.InputMismatchException;
public class ManageTestScores {

	//Method to calculate and display the average score.
    static double displayAverage(int[] arr) {
    	int sum = 0;
    	int n = arr.length;
    	
    	for(int i=0; i<n; i++) {
    		sum += arr[i];
    	}
    	
    	double average = sum/n;
    	System.out.println("\nThe average is: "+average);
    	return average;
    }
    
    //Method to find and display the highest and lowest scores.
    static void displayHighestAndLowestScores(int[] arr) {
    	int minScore = Integer.MAX_VALUE;
    	int maxScore = Integer.MIN_VALUE;
    	int n = arr.length;
    	
    	for(int i=0; i<n; i++) {
    		if(arr[i]<minScore) {
    			minScore = arr[i];
    		}
    		if(arr[i]>maxScore) {
    			maxScore = arr[i];
    		}
    	}
    	
    	System.out.println("\nThe highest score is: "+maxScore);
    	System.out.println("The lowest score is: "+minScore);
    }
    
    //Method to identify and display the scores above the average.
    static void displayScoresAboveAverage(int[] arr, double avg) {
    	System.out.println("Score above average are: ");
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i]>avg) {
    			System.out.print(arr[i]+" ");
    		}
    	}
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of students");
		int n = sc.nextInt();
		
		//Storing the scores of n students in an array.
		//Handling invalid input like negative scores or non-numeric input.
		int[] arr = new int[n];
		System.out.println("Enter the scores of the students: ");
		for(int i=0; i<n;i++) {
			System.out.printf("Score of student %d is: ",i+1);
			try {
				arr[i] = sc.nextInt();
				if(arr[i]<0) {
					System.out.println("Warning ! Negative number");
				}
			}catch(InputMismatchException e) {
				System.err.println("Non-numeric digit entred.");
				sc.next();
				i--;
				System.out.println("Reason: "+e);
			}
			
		}
		
		double average = displayAverage(arr);
		displayHighestAndLowestScores(arr);
		displayScoresAboveAverage(arr, average);
		
		sc.close();
	}

}
