package scenario_based;

import java.util.*;

//Custom exception
class InsufficientLeaveBalanceException extends Exception {
 public InsufficientLeaveBalanceException(String empId, int reqDays) {
     super("Emp " + empId + ": insufficient balance for " + reqDays + " days");
 }
}

class Employees {
 private String id;
 private String name;
 private int leaveBalance;
 
 public Employees(String id, String name, int balance) {
     this.id = id;
     this.name = name;
     this.leaveBalance = balance;
 }
 
 public String getId() { return id; }
 public String getName() { return name; }
 public int getLeaveBalance() { return leaveBalance; }
 public void deductBalance(int days) { leaveBalance -= days; }
}

class LeaveRequest {
 private String id;
 private String empId;
 private int days;
 private String status = "pending";
 
 public LeaveRequest(String id, String empId, int days) {
     this.id = id;
     this.empId = empId;
     this.days = days;
 }
 
 public String getId() { return id; }
 public String getEmpId() { return empId; }
 public int getDays() { return days; }
 public String getStatus() { return status; }
 public void setStatus(String status) { this.status = status; }
}

public class EmployeeLeaveManagementSystem{
 private Map<String, Employees> employees = new HashMap<>();
 private List<LeaveRequest> requests = new ArrayList<>();
 private Scanner sc = new Scanner(System.in);
 
 public void addEmployee() {
     System.out.print("Emp ID: ");
     String id = sc.next();
     System.out.print("Name: ");
     String name = sc.next();
     System.out.print("Leave balance: ");
     int balance = sc.nextInt();
     employees.put(id, new Employees(id, name, balance));
     System.out.println("Added " + name);
 }
 
 public void addRequest() {
     System.out.print("Request ID: ");
     String rid = sc.next();
     System.out.print("Emp ID: ");
     String eid = sc.next();
     System.out.print("Days: ");
     int days = sc.nextInt();
     
     Employees emp = employees.get(eid);
     if (emp == null) {
         System.out.println("Emp not found");
         return;
     }
     
     requests.add(new LeaveRequest(rid, eid, days));
     System.out.println("Request added");
 }
 
 public void approveRequest() throws InsufficientLeaveBalanceException {
     System.out.print("Request ID: ");
     String rid = sc.next();
     
     LeaveRequest req = null;
     for (LeaveRequest r : requests) {
         if (r.getId().equals(rid) && "pending".equals(r.getStatus())) {
             req = r;
             break;
         }
     }
     
     if (req == null) {
         System.out.println("Invalid/processed request");
         return;
     }
     
     Employees emp = employees.get(req.getEmpId());
     if (emp.getLeaveBalance() < req.getDays()) {
         throw new InsufficientLeaveBalanceException(emp.getId(), req.getDays());
     }
     
     emp.deductBalance(req.getDays());
     req.setStatus("approved");
     System.out.println("Approved " + rid);
 }
 
 public void viewRequests() {
     System.out.println("Requests:");
     for (LeaveRequest r : requests) {
         System.out.println(r.getId() + " - " + r.getEmpId() + " (" + r.getDays() + "d) : " + r.getStatus());
     }
 }
 
 public void menu() {
     while (true) {
         System.out.print("\n1.Add Emp 2.Add Req 3.Approve 4.View 0.Exit: ");
         int choice = sc.nextInt();
         try {
             if (choice == 1) addEmployee();
             else if (choice == 2) addRequest();
             else if (choice == 3) approveRequest();
             else if (choice == 4) viewRequests();
             else if (choice == 0) break;
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
     sc.close();
 }
 
 public static void main(String[] args) {
     new EmployeeLeaveManagementSystem().menu();
 }
}
