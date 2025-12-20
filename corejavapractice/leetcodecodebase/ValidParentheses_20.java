package leetcodecodebase;

import java.util.*;
public class ValidParentheses_20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//taking user input as string and storing in a string variable
		System.out.printf("Enter the string: ");
		String str = sc.nextLine();
		
		boolean result = isValid(str);
		//Displaying the output
		System.out.printf("Is the string '%s' valid ? %s", str,result);
	}
	static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                s.push(c);
            }
            else{
                 if(s.isEmpty() || !issame(s.pop(), c)){
                    return false;
                }
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
    static boolean issame(char open, char close) {
        return (open=='(' && close ==')') || (open=='{' && close =='}') || (open=='[' && close ==']');
    }
}
