package scenario_based.OnlineExaminationSystem;

// Question entity
public class Question {

    private int questionId;
    private String questionText;
    private String correctAnswer;

    public Question(int questionId, String questionText, String correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }
}
