package employee_wage;

public class UC8_MultipleCompany {

	public static int computeWage(String company, int wagePerHour, int maxDays, int maxHours) {

		int totalHours = 0;
		int totalDays = 0;

		while (totalHours <= maxHours && totalDays < maxDays) {
			totalDays++;
			int empCheck = (int) (Math.random() * 3);
			int empHours = (empCheck == 2) ? 8 : (empCheck == 1) ? 4 : 0;
			totalHours += empHours;
		}

		int totalWage = totalHours * wagePerHour;
		System.out.println(company + " Total Wage: " + totalWage);
		return totalWage;
	}

	public static void main(String[] args) {
		computeWage("TCS", 20, 20, 100);
		computeWage("Infosys", 25, 22, 120);
	}
}