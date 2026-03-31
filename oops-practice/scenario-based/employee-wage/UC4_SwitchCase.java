package employee_wage;

public class UC4_SwitchCase {

    public static void main(String[] args) {

        int WAGE_PER_HOUR = 20;
        int empCheck = (int) (Math.random() * 3);
        int empHours = 0;

        switch (empCheck) {
            case 1:
                empHours = 4;
                break;
            case 2:
                empHours = 8;
                break;
            default:
                empHours = 0;
        }

        System.out.println("Daily Wage: " + (empHours * WAGE_PER_HOUR));
    }
}
