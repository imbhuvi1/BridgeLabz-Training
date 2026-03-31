package gcr_codebase.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Calculator {
	private int multiply(int a, int b) {
		return a * b;
	}
}

public class PrivateMethod {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
		method.setAccessible(true);
		int result = (int) method.invoke(calc, 5, 4);
		System.out.println("Result: " + result);
	}

}
