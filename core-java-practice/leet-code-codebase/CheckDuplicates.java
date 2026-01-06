package leet_code_codebase;

import java.util.*;

public class CheckDuplicates {
	public static void main(String[] args) {
		CheckDuplicates solution = new CheckDuplicates();
		
		int[] arr = {3,3,3,4,5,6,7,2,4,5,5};
		System.out.println(solution.containsDuplicate(arr));
	}
	
	//LeetCode solution
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i)) {
				return true;
			}
			set.add(i);
		}
		return false;
	}

}
