
public class GenerateGreater {
	
	public static void getAllGreaterElements(String str, char target) {
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>'c') {
				System.out.print(str.charAt(i)+" ");
			}
		}
	}
	public static void main(String[] args) {
		String str = "cfj";
		char targetElement = 'c';
		System.out.println("Elements greater than '"+targetElement+"' in string '"+str+"' are: ");
		getAllGreaterElements(str, targetElement);
	}
}
