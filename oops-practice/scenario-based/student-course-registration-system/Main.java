package scenario_based.StudentCourseRegistrationSystem;

public class Main {
    public static void main(String[] args) {

        Student student = new Student(1, "Rahul");

        Course c1 = new Course(101, "Data Structures");
        Course c2 = new Course(102, "Operating Systems");
        Course c3 = new Course(103, "DBMS");
        Course c4 = new Course(104, "Computer Networks");

        RegistrationService service = new RegistrationServiceImpl();

        try {
            service.register(student, c1);
            service.register(student, c2);
            service.register(student, c3);
            service.register(student, c4); // ❌ exception
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        service.assignGrade(c1, 'A');
        service.assignGrade(c2, 'B');

        System.out.println("\nEnrolled Courses:");
        for (Course c : student.getEnrolledCourses()) {
            c.displayCourse();
        }
    }
}
