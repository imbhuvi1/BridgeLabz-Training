package gcr_codebase.reflections;

import java.lang.reflect.Field;

class Person {
	private int age = 20;
}

public class PrivateField {

	public static void main(String[] args)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Person person = new Person();
		Field field = Person.class.getDeclaredField("age");
		field.setAccessible(true);
		System.out.println("Age: " + field.get(person));
		field.set(person, 30);
		System.out.println("Age: " + field.get(person));
	}

}