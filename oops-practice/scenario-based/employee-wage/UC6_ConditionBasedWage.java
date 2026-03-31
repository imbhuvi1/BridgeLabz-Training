package employee_wage;

public class UC6_ConditionBasedWage {

    public static void main(String[] args) {

        int WAGE_PER_HOUR = 20;
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours <= 100 && totalDays < 20) {

            totalDays++;
            int empCheck = (int) (Math.random() * 3);
            int empHours = 0;

            switch (empCheck) {
                case 1: empHours = 4; break;
                case 2: empHours = 8; break;
            }

            totalHours += empHours;
            totalWage += empHours * WAGE_PER_HOUR;
        }

        System.out.println("Total Wage: " + totalWage);
    }
}
