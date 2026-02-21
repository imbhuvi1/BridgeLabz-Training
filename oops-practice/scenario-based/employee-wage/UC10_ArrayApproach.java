package employee_wage;

class UC10_ArrayApproach {

    public static void main(String[] args) {

        CompanyEmpWage_UC9[] companies = new CompanyEmpWage_UC9[2];

        companies[0] = new CompanyEmpWage_UC9("TCS", 20, 20, 100);
        companies[1] = new CompanyEmpWage_UC9("Infosys", 25, 22, 120);

        for (CompanyEmpWage_UC9 company : companies) {
            company.computeWage();
        }
    }
}
