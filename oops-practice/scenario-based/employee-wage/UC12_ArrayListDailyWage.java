package employee_wage;

import java.util.ArrayList;

public class UC12_ArrayListDailyWage {

	public static void main(String[] args) {

		String companyName = "TCS";
		int wagePerHour = 20;
		int maxDays = 20;
		int maxHours = 100;

		int totalHours = 0;
		int totalDays = 0;

		ArrayList<Integer> dailyWages = new ArrayList<>();

		while (totalHours <= maxHours && totalDays < maxDays) {

			totalDays++;
			int empCheck = (int) (Math.random() * 3);
			int empHours = (empCheck == 2) ? 8 : (empCheck == 1) ? 4 : 0;

			totalHours += empHours;
			dailyWages.add(empHours * wagePerHour);
		}

		int totalWage = totalHours * wagePerHour;

		System.out.println("Daily Wages: " + dailyWages);
		System.out.println(companyName + " Total Wage: " + totalWage);
	}
}