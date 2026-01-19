package scenario_based;

//Abstract Employee class
abstract class Employee {
 private final String name;   // immutable
 private final double salary; // immutable
 protected final double bonus; // cached bonus

 public Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
     this.bonus = calculateBonus(); // compute once
 }

 protected double getSalary() {
     return salary;
 }

 protected abstract double calculateBonus();

 public double getBonus() {
     return bonus;
 }
}

//Manager implementation
class Manager extends Employee {

 public Manager(String name, double salary) {
     super(name, salary);
 }

 @Override
 protected double calculateBonus() {
     return getSalary() * 0.10; // 10% bonus
 }
}

//Developer implementation
class Developer extends Employee {

 public Developer(String name, double salary) {
     super(name, salary);
 }

 @Override
 protected double calculateBonus() {
     return getSalary() > 50000 ? getSalary() * 0.05 : 0.0;
 }
}

//Test class
class EmployeeTest {
 public static void main(String[] args) {
     Employee manager = new Manager("Alice", 80000);
     System.out.printf("%.2f%n", manager.getBonus()); // 8000.00
 }
}

