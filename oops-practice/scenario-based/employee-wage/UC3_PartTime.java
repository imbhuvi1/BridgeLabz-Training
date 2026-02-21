package employee_wage;

public class UC3_PartTime {

    public static void main(String[] args) {

        int WAGE_PER_HOUR = 20;
        int PART_TIME = 1;
        int FULL_TIME = 2;

        int empCheck = (int) (Math.random() * 3);
        int empHours = 0;

        if (empCheck == PART_TIME)
            empHours = 4;
        else if (empCheck == FULL_TIME)
            empHours = 8;

        int dailyWage = empHours * WAGE_PER_HOUR;
        System.out.println("Daily Wage: " + dailyWage);
    }
}
