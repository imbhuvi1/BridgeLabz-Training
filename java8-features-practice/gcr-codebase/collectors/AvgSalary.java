package gcr_codebase.collectors;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String department;
    double salary;

    Employee(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() { return department; }
    double getSalary() { return salary; }
}

public class AvgSalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("IT", 60000),
            new Employee("HR", 45000),
            new Employee("IT", 70000)
        );

        employees.stream()
                 .collect(Collectors.groupingBy(
                     Employee::getDepartment,
                     Collectors.averagingDouble(Employee::getSalary)
                 ))
                 .forEach((dept, avg) ->
                     System.out.println(dept + " : " + avg)
                 );
    }
}
