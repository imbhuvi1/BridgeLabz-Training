package gcr_codebase.collectors;

import java.util.*;
import java.util.stream.*;

class Students{
	String name;
	char grade;
	
	public Students(String name, char grade) {
		this.name = name;
		this.grade = grade;
	}
	
	String getStudentName(){
		return name;
	}
	
	char getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
public class StudentResultGrouping {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Students> list = List.of(
				new Students("Bhuvnesh", 'A'), 
				new Students("Manish", 'B'), 
				new Students("Arpit",'A'),
				new Students("Shravan",'A'),
				new Students("Ayush",'B')
				);
		
		Map<Character,List<Students>> map = list.stream()
				.collect(Collectors.groupingBy(
						s-> s.grade)); 
		
		
		System.out.println(map);
		
		sc.close();
	}
}
