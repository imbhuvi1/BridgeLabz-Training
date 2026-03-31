package gcr_codebase.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Task {
	public void runTask() {
		for (int i = 0; i < 1000000; i++) {

		}
	}
}

public class MethodTimer {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		// TODO Auto-generated method stub
		Class<?> clazz = Task.class;
		Object obj = clazz.getDeclaredConstructor().newInstance();
		for (Method method : clazz.getDeclaredMethods()) {
			long start = System.nanoTime();
			method.invoke(obj);
			long end = System.nanoTime();
			System.out.println(method.getName() + " executed in " + (end - start) + " ns");
		}
	}

}
