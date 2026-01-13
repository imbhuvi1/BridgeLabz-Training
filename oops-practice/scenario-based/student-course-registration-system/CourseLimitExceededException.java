package scenario_based.StudentCourseRegistrationSystem;

public class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String message) {
        super(message);
    }
}

