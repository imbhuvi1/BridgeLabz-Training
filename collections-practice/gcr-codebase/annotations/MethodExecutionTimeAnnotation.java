package gcr_codebase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class ExecutionTasks {

	@LogExecutionTime
	public void smallTask() {
		int sum = 0;
		for (int i = 0; i < 10_000; i++) {
			sum += i;
		}
	}

	@LogExecutionTime
	public void mediumTask() {
		long result = 1;
		for (int i = 1; i < 100_000; i++) {
			result *= i;
			result %= 1_000_000;
		}
	}

	@LogExecutionTime
	public void longTask() {
		double value = 0;
		for (int i = 1; i < 1_000_000; i++) {
			value += Math.sqrt(i);
		}
	}
}

public class MethodExecutionTimeAnnotation {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		ExecutionTasks tasks = new ExecutionTasks();
		Class<ExecutionTasks> c = ExecutionTasks.class;
		for (Method method : c.getDeclaredMethods()) {
			if (method.isAnnotationPresent(LogExecutionTime.class)) {
				long startTime = System.nanoTime();
				method.invoke(tasks);
				long endTime = System.nanoTime();
				System.out.println("Method Name    : " + method.getName());
				System.out.println("Execution Time : " + (endTime - startTime) + " ns");
				System.out.println();
			}
		}
	}

}
