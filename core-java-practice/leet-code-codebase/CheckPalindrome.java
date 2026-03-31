package leet_code_codebase;

import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isPalindrome(s));
        sc.close();
    }
    private static boolean isPalindrome(String s){
        StringBuilder s2 = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            s2.append(s.charAt(i));
        }
        return s2.toString().equals(s);
    }
}
