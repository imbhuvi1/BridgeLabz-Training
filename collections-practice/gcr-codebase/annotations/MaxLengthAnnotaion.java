package gcr_codebase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
	int value();
}

class User {
	@MaxLength(10)
	private String username;

	public User(String username) {
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(MaxLength.class)) {
				MaxLength maxLength = field.getAnnotation(MaxLength.class);
				if (field.getName().equals("username")) {
					if (username != null && username.length() > maxLength.value()) {
						throw new IllegalArgumentException("Username length should not exceed " + maxLength.value());
					}
				}
			}
		}
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}

public class MaxLengthAnnotaion {

	public static void main(String[] args) {
		User user1 = new User("Govind");
		System.out.println("User created: " + user1.getUsername());
		User user2 = new User("GovindNAcharya");
	}
}