package gcr_codebase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
	String level() default "HIGH";
}

class Check {
	@ImportantMethod
	public void method1() {
		System.out.println("Method1");
	}

	@ImportantMethod(level = "MEDIUM")
	public void method2() {
		System.out.println("Method2");
	}

	@ImportantMethod(level = "LOW")
	public void method3() {
		System.out.println("Method3");
	}
}

public class ImportantAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<Check> check = Check.class;

		for (Method method : check.getDeclaredMethods()) {
			if (method.isAnnotationPresent(ImportantMethod.class)) {
				ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
				System.out.println("Method: " + method.getName() + " Level: " + annotation.level());
			}
		}
	}

}
