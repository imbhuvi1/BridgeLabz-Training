package gcr_codebase.streamapi;

import java.util.*;

public class EmailNotification {

	static void sendEmailNotification(String email) {
		System.out.println("Email sent to: " + email);
	}

	public static void main(String[] args) {

		List<String> emails = Arrays.asList("a@mail.com", "b@mail.com", "c@mail.com");

		// Send email to each user
		emails.forEach(email -> sendEmailNotification(email));
	}
}
