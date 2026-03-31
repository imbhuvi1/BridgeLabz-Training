package employee_wage;

public class UC1_EmployeeAttendance {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int IS_PRESENT = 1;
//        System.out.println(Math.random());
        int empCheck = (int) (Math.random() * 2);

        if (empCheck == IS_PRESENT)
            System.out.println("Employee is Present");
        else
            System.out.println("Employee is Absent");
    }
}