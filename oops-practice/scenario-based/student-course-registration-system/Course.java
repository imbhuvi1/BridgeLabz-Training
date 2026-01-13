package scenario_based.StudentCourseRegistrationSystem;

public class Course {
    private int courseId;
    private String courseName;
    private char grade;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.grade = '-';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void displayCourse() {
        System.out.println(courseId + " | " + courseName + " | Grade: " + grade);
    }
}
