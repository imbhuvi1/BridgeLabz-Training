package leet_code_codebase;

public class ValidPalindrome {

	public static void main(String[] args) {
		String str = "radar";
		
		System.out.println(isPalindrome(str));
	}
	
	//LeetCode solution - inside Solution Class
	//making the method static here
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                sb.append(ch);
            }
            else if(Character.isDigit(ch)){
                sb.append(ch);
            }
        }
        for(int i = 0; i < sb.length()/2; i++){
            if(sb.charAt(i) != sb.charAt(sb.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

}
