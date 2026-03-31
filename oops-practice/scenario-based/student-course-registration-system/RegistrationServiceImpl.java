package scenario_based.StudentCourseRegistrationSystem;

public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public void register(Student student, Course course) throws CourseLimitExceededException {
        student.enrollCourse(course);
    }

    @Override
    public void drop(Student student, Course course) {
        student.dropCourse(course);
    }

    @Override
    public void assignGrade(Course course, char grade) {
        course.setGrade(grade);
    }
}
