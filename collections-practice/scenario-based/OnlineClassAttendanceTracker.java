package scenario_based;

import java.util.*;

//Custom exception
class DuplicateAttendanceException extends Exception {
 public DuplicateAttendanceException(String studentId, String sessionId) {
     super("Duplicate: " + studentId + " in " + sessionId);
 }
}

class AttendanceTracker {
 private Map<String, Set<String>> attendance = new HashMap<>();
 
 public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
     Set<String> students = attendance.computeIfAbsent(sessionId, k -> new HashSet<>());
     if (!students.add(studentId)) {
         throw new DuplicateAttendanceException(studentId, sessionId);
     }
 }
 
 public void removeAttendance(String sessionId, String studentId) {
     Set<String> students = attendance.get(sessionId);
     if (students != null) {
         students.remove(studentId);
         if (students.isEmpty()) {
             attendance.remove(sessionId);
         }
     }
 }
 
 public void displayAttendance(String sessionId) {
     Set<String> students = attendance.get(sessionId);
     if (students == null || students.isEmpty()) {
         System.out.println("Empty session: " + sessionId);
     } else {
         System.out.println(sessionId + ": " + students);
     }
 }
 
 public void displayAll() {
     attendance.forEach((sid, studs) -> System.out.println(sid + ": " + studs));
 }
}

//Test
public class OnlineClassAttendanceTracker {
 public static void main(String[] args) {
     AttendanceTracker tracker = new AttendanceTracker();
     try {
         tracker.markAttendance("S1", "ST1");
         tracker.markAttendance("S1", "ST2");
         tracker.markAttendance("S1", "ST1"); // throws exception
     } catch (DuplicateAttendanceException e) {
         System.out.println(e.getMessage());
     }
     tracker.displayAttendance("S1");
     tracker.removeAttendance("S1", "ST1");
     tracker.displayAttendance("S1");
 }
}
