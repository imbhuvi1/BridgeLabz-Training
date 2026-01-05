package scenerio_based;

import java.util.Scanner;
public class TemperatureAnalyzer {

	
	//method to find hottest and coldest temperature
	static void findHottestAndColdestTemp(int[][]arr) {
		int n = arr.length;
		int m = arr[0].length;
		
		int hottestTemp = Integer.MIN_VALUE;
		int coldestTemp = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]>hottestTemp) {
					hottestTemp = arr[i][j];
				}
				if(arr[i][j]<coldestTemp) {
					coldestTemp = arr[i][j];
				}
			}
		}
		
		System.out.println("Hottest day: "+hottestTemp);
		System.out.println("Coldest day: "+coldestTemp);
	}
	
	static void returnAverageTempPerDay(int [][]arr) {
		int n = arr.length;
		int m = arr[0].length;
		
		int averageTemp = 0;
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sum+=arr[i][j];
				averageTemp = sum/n;
			}
			System.out.printf("Average temp for Day %d: %d",(i+1), averageTemp);
			System.out.println();
			sum=0;;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[7][24];
		
		System.out.println("Enter the temperature: ");
		for(int i=0; i<7; i++) {
			System.out.printf("Day %d: ",(i+1));
			for(int j=0; j<24; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		findHottestAndColdestTemp(arr);
		returnAverageTempPerDay(arr);
		sc.close();
	}

}
