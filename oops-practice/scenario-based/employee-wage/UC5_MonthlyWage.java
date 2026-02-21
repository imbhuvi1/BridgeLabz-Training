package employee_wage;

public class UC5_MonthlyWage {

    public static void main(String[] args) {

        int WAGE_PER_HOUR = 20;
        int totalWage = 0;

        for (int day = 1; day <= 20; day++) {

            int empCheck = (int) (Math.random() * 3);
            int empHours = 0;

            switch (empCheck) {
                case 1: empHours = 4; break;
                case 2: empHours = 8; break;
            }

            totalWage += empHours * WAGE_PER_HOUR;
        }

        System.out.println("Total Monthly Wage: " + totalWage);
    }
}
