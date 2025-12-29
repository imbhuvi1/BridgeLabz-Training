package scenerio_based;

import java.util.ArrayList;

class Employee {

 static final int WAGE_PER_HOUR = 20;
 static final int MAX_WORKING_DAYS = 20;
 static final int MAX_WORKING_HOURS = 100;

 int empId;
 int totalWorkingHours;
 int totalWorkingDays;

 Employee(int empId) {
     this.empId = empId;
 }

 int calculateWage() {
     return totalWorkingHours * WAGE_PER_HOUR;
 }

 void computeMonthlyWage() {

     while (totalWorkingHours < MAX_WORKING_HOURS &&
            totalWorkingDays < MAX_WORKING_DAYS) {

         totalWorkingDays++;

         int empCheck = (int) (Math.random() * 3);
         int empHours = 0;

         switch (empCheck) {
             case 1: 
                 empHours = 8;
                 break;

             case 2: 
                 empHours = 8;
                 break;

             default:
                 empHours = 0;
         }

         totalWorkingHours += empHours;
     }
 }
}

public class EmployeeWageComputation {

 static void displayWelcomeMessage() {
     System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
 }

 public static void main(String[] args) {

     displayWelcomeMessage();

     ArrayList<Employee> employeeList = new ArrayList<>();

     employeeList.add(new Employee(101));
     employeeList.add(new Employee(102));
     employeeList.add(new Employee(103));

     for (Employee emp : employeeList) {
         emp.computeMonthlyWage();
         System.out.println("Employee ID          : " + emp.empId);
         System.out.println("Total Working Days   : " + emp.totalWorkingDays);
         System.out.println("Total Working Hours  : " + emp.totalWorkingHours);
         System.out.println("Total Monthly Wage   : ₹" + emp.calculateWage());
     }
 }
}
