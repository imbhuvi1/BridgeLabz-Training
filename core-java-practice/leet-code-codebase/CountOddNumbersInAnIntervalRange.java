package leet_code_codebase;

public class CountOddNumbersInAnIntervalRange {
	public static void main(String[] args) {
		CountOddNumbersInAnIntervalRange solution = new CountOddNumbersInAnIntervalRange();
		
		int low = 2;
		int high = 20;
		
		System.out.println(solution.countOdds(low,high));
		;
	}
	//LeetCode solution - inside Solution Class
	    public int countOdds(int low, int high) {
	        int diff = high - low + 1;
	        if(low % 2 != 0 && high % 2 != 0){
	            return diff / 2 + 1;
	        }
	       return diff / 2;
	    }

}
