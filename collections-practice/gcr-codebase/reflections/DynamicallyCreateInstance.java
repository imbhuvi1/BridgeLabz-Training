package gcr_codebase.reflections;

import java.lang.reflect.InvocationTargetException;

class Student {

    public Student() {
        System.out.println("Student object created");
    }
}


public class DynamicallyCreateInstance {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		// TODO Auto-generated method stub
		Class<?> student = Student.class;
        Object obj = student.getDeclaredConstructor().newInstance();
        System.out.println("Object: " + obj.getClass().getName());
	}

}
