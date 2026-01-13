package scenario_based.StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<Course> enrolledCourses;
    private static final int MAX_COURSES = 3;

    public Student(int id, String name) {
        super(id, name);
        enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (enrolledCourses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded!");
        }
        enrolledCourses.add(course);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void dropCourse(Course course) {
        enrolledCourses.remove(course);
        System.out.println(name + " dropped " + course.getCourseName());
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
}

