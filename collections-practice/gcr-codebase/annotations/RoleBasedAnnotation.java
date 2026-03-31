package gcr_codebase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
	String value();
}

@RoleAllowed("ADMIN")
class AdminClass {
	public void deleteUser() {
		System.out.println("User deleted successfully!");
	}
}

class RoleValidator {
	public static void invokeMethod(Object obj, String currentUserRole) {
		Class<?> clazz = obj.getClass();
		if (clazz.isAnnotationPresent(RoleAllowed.class)) {
			RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
			if (!roleAllowed.value().equals(currentUserRole)) {
				System.out.println("Access Denied!");
				return;
			}
		}
		try {
			Method method = clazz.getDeclaredMethod("deleteUser");
			method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class RoleBasedAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminClass admin = new AdminClass();
		RoleValidator.invokeMethod(admin, "ADMIN");
		RoleValidator.invokeMethod(admin, "USER");
	}
}