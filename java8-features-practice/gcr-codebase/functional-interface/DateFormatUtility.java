package gcr_codebase.functional_interface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateFormatter {
	static String formatDate(LocalDate date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return date.format(formatter);
	}
}

public class DateFormatUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		System.out.println("Default format: " + DateFormatter.formatDate(date, "yyyy-MM-dd"));
		System.out.println("Default format: " + DateFormatter.formatDate(date, "dd MMM yy"));
		System.out.println("Default format: " + DateFormatter.formatDate(date, "MM/dd/yyyy"));
	}

}
