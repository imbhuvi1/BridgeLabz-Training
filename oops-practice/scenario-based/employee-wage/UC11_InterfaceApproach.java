package employee_wage;

interface IEmpWageBuilder_UC11 {
	void computeWage();
}

class CompanyEmpWage_UC11 implements IEmpWageBuilder_UC11 {

	String companyName;
	int wagePerHour;
	int maxDays;
	int maxHours;

	public CompanyEmpWage_UC11(String companyName, int wagePerHour, int maxDays, int maxHours) {
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

		System.out.println(companyName + " Total Wage: " + (totalHours * wagePerHour));
	}
}

public class UC11_InterfaceApproach {

	public static void main(String[] args) {

		IEmpWageBuilder_UC11 company = new CompanyEmpWage_UC11("TCS", 20, 20, 100);

		company.computeWage();
	}
}
