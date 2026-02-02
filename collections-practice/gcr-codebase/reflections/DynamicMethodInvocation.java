package gcr_codebase.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class MathOperations {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
}

public class DynamicMethodInvocation {

	public static void main(String[] args)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter method name (add, subtract, multiply):");
		String methodName = sc.nextLine();
		MathOperations math = new MathOperations();
		Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
		Object result = method.invoke(math, 10, 5);
		System.out.println("Result: " + result);
	}

}