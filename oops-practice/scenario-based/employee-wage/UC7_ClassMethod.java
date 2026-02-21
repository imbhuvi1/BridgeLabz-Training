package employee_wage;

public class UC7_ClassMethod {

	static final int WAGE_PER_HOUR = 20;
	static final int MAX_HOURS = 100;
	static final int MAX_DAYS = 20;

	public static int computeWage() {

		int totalHours = 0;
		int totalDays = 0;

		while (totalHours <= MAX_HOURS && totalDays < MAX_DAYS) {
			totalDays++;
			int empCheck = (int) (Math.random() * 3);
			int empHours = (empCheck == 2) ? 8 : (empCheck == 1) ? 4 : 0;
			totalHours += empHours;
		}

		return totalHours * WAGE_PER_HOUR;
	}

	public static void main(String[] args) {
		System.out.println("Total Wage: " + computeWage());
	}
}
