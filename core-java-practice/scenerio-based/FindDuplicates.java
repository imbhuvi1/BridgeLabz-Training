package scenerio_based;

import java.util.*;
public class FindDuplicates {

	void findDuplicated(int n, int[] arr) {
		//stores frequency based on indexing
		int[] freq = new int[100000];
		for(int i=0; i<n; i++) {
			freq[arr[i]]++;
		}
		
		//array to store duplicate elements as they are index of frequency array
		int[] duplicates = new int[n];
		int idx = 0;
		for(int i=0; i<freq.length; i++) {
			if(freq[i]>1) {
				duplicates[idx++] = i;
			}
		}
		
		//displaying elements
		System.out.println("Displaying elements: ");
		for(int i=0; i<n; i++) {
			if(duplicates[i]!=0)
			System.out.print(duplicates[i]+" ");
		}
	}
	public static void main(String[] args) {
		FindDuplicates obj = new FindDuplicates();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the length: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter array elements less than 100000");
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		obj.findDuplicated(n,arr);
		
		sc.close();
	}

}
