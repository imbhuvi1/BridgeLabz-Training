package employee_wage;

import java.util.ArrayList;

class CompanyEmpWage_UC9 {

	String companyName;
	int wagePerHour;
	int maxDays;
	int maxHours;
	int totalWage;

	public CompanyEmpWage_UC9(String companyName, int wagePerHour, int maxDays, int maxHours) {
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxDays = maxDays;
		this.maxHours = maxHours;
	}

	public void computeWage() {

		int totalHours = 0;
		int totalDays = 0;

		while (totalHours <= maxHours && totalDays < maxDays) {
			totalDays++;
			int empCheck = (int) (Math.random() * 3);
			int empHours = (empCheck == 2) ? 8 : (empCheck == 1) ? 4 : 0;
			totalHours += empHours;
		}

		totalWage = totalHours * wagePerHour;
		System.out.println(companyName + " Total Wage: " + totalWage);
	}
}

public class UC9_InstanceVariable {

	public static void main(String[] args) {

		CompanyEmpWage_UC9 company = new CompanyEmpWage_UC9("TCS", 20, 20, 100);

		company.computeWage();
	}
}
