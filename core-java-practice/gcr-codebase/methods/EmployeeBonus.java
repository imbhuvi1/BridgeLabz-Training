package gcr_codebase.methods;

import java.util.*;

public class EmployeeBonus {

    //Method to generate salary and years of service
    public static int[][] generateEmployeeData(int employees) {

        int[][] data = new int[employees][2];

        for (int i = 0; i < employees; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000;
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }

    //Method to calculate new salary and bonus
    public static double[][] calculateBonus(int[][] data) {

        double[][] result = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    //Method to calculate totals and display in tabular format
    public static void displayResult(int[][] oldData, double[][] newData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("emp\told salary\tyears\tbonus\t\tnew salary");

        for (int i = 0; i < oldData.length; i++) {

            totalOldSalary += oldData[i][0];
            totalNewSalary += newData[i][0];
            totalBonus += newData[i][1];

            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%.2f\n",(i + 1),oldData[i][0],oldData[i][1],newData[i][1],newData[i][0]);
        }

        System.out.println();
        System.out.printf("total\t%.2f\t\t-\t%.2f\t%.2f\n",totalOldSalary, totalBonus, totalNewSalary);
    }

    // main method
    public static void main(String[] args) {

        int employees = 10;

        int[][] employeeData = generateEmployeeData(employees);
        double[][] salaryDetails = calculateBonus(employeeData);

        displayResult(employeeData, salaryDetails);
    }
}

