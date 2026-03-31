package scenario_based.OnlineExaminationSystem;

import java.util.ArrayList;
import java.util.List;

// Exam entity
public class Exam {

    private String examName;
    private List<Question> questions = new ArrayList<>();

    public Exam(String examName) {
        this.examName = examName;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getExamName() {
        return examName;
    }
}
