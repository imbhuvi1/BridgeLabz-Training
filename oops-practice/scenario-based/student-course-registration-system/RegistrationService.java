package scenario_based.StudentCourseRegistrationSystem;

public interface RegistrationService {
    void register(Student student, Course course) throws CourseLimitExceededException;
    void drop(Student student, Course course);
    void assignGrade(Course course, char grade);
}
