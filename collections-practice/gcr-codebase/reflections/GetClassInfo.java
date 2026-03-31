package gcr_codebase.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Demo {
	String name;

	Demo(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Name: " + name);
	}
}

public class GetClassInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> demo = Demo.class;
		System.out.println("Class Name: " + demo.getName());
		System.out.println();
		System.out.println("Methods: ");
		for (Method method : demo.getDeclaredMethods()) {
			System.out.println(method.getName());
		}
		System.out.println();
		System.out.println("Fields: ");
		for (Field field : demo.getDeclaredFields()) {
			System.out.println(field.getName());
		}
		System.out.println();
		System.out.println("Constructors: ");
		for (Constructor<?> cons : demo.getDeclaredConstructors()) {
			System.out.println(cons.getName());
		}
	}

}