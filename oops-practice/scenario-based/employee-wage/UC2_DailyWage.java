package employee_wage;

public class UC2_DailyWage {

    public static void main(String[] args) {

        int WAGE_PER_HOUR = 20;
        int FULL_DAY_HOUR = 8;

        int empCheck = (int) (Math.random() * 2);
        int dailyWage = 0;

        if (empCheck == 1)
            dailyWage = WAGE_PER_HOUR * FULL_DAY_HOUR;

        System.out.println("Daily Wage: " + dailyWage);
    }
}
