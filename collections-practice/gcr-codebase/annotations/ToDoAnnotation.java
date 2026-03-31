package gcr_codebase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
	String task();

	String assignedTo();

	String priority() default "MEDIUM";
}

class Tasks {

	@Todo(task = "Add Task 1", assignedTo = "Govind", priority = "HIGH")
	public void Task1() {
	}

	@Todo(task = "Add Task 2", assignedTo = "Akash")
	public void Task2() {
	}

	@Todo(task = "Add Task 3", assignedTo = "Nitai", priority = "LOW")
	public void Task3() {
	}
}

public class ToDoAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<Tasks> c = Tasks.class;
		for (Method method : c.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Todo.class)) {
				Todo todo = method.getAnnotation(Todo.class);
				System.out.println("Method Name : " + method.getName());
				System.out.println("Task        : " + todo.task());
				System.out.println("Assigned To : " + todo.assignedTo());
				System.out.println("Priority    : " + todo.priority());
				System.out.println();
			}
		}
	}

}
