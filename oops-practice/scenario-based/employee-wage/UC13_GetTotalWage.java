package employee_wage;

import java.util.ArrayList;

class CompanyEmpWage_UC13 {

	String companyName;
	int totalWage;

	public CompanyEmpWage_UC13(String name, int wage) {
		this.companyName = name;
		this.totalWage = wage;
	}
}

public class UC13_GetTotalWage {

	public static void main(String[] args) {

		ArrayList<CompanyEmpWage_UC13> list = new ArrayList<>();

		list.add(new CompanyEmpWage_UC13("TCS", 2000));
		list.add(new CompanyEmpWage_UC13("Infosys", 3000));

		String searchCompany = "TCS";

		for (CompanyEmpWage_UC13 company : list) {
			if (company.companyName.equals(searchCompany)) {
				System.out.println("Total Wage of " + searchCompany + " = " + company.totalWage);
			}
		}
	}
}
