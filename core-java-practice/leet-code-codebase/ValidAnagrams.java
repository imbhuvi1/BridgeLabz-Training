public class ValidAnagrams {
	public static void main(String[] args) {
		String a = "listen";
		String b = "silent";
		
		System.out.println(isAnagram(a,b));
	}
	
	//LeetCode solution - inside Solution Class
	//making the method static here
    public static boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()){
            return false;
        }   
        int freq[] = new int[26];
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            char ch2 = t.charAt(i);
            freq[ch - 'a']++;
            freq[ch2 - 'a']--;
        }
        // System.out.println(Arrays.toString(freq));
        for(int i : freq){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
