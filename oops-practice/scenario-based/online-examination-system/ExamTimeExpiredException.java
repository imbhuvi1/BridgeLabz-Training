package scenario_based.OnlineExaminationSystem;

// Custom exception
public class ExamTimeExpiredException extends Exception {

    public ExamTimeExpiredException(String message) {
        super(message);
    }
}
