package scenario_based;
import java.util.*;

// ExamProctor class
class ExamProctor {

    // Stack to track question navigation
    private Stack<Integer> navigationStack = new Stack<>();

    // HashMap to store answers (questionId -> answer)
    private HashMap<Integer, String> answers = new HashMap<>();

    // Visit a question
    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    // Store answer
    public void answerQuestion(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    // Calculate score using a function
    public int calculateScore(HashMap<Integer, String> correctAnswers) {
        int score = 0;

        for (int qid : answers.keySet()) {
            if (answers.get(qid).equals(correctAnswers.get(qid))) {
                score++;
            }
        }
        return score;
    }

    // Display navigation history
    public void showNavigationHistory() {
        System.out.println("\nQuestion Navigation History:");
        while (!navigationStack.isEmpty()) {
            System.out.println("Question " + navigationStack.pop());
        }
    }
}

// Main class
public class ExamProctorSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExamProctor exam = new ExamProctor();

        System.out.print("Enter number of questions attempted: ");
        int n = sc.nextInt();

        // User input for navigation and answers
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Question ID: ");
            int qid = sc.nextInt();

            exam.visitQuestion(qid);

            System.out.print("Enter your answer: ");
            String ans = sc.next();

            exam.answerQuestion(qid, ans);
        }

        // Input correct answers
        HashMap<Integer, String> correctAnswers = new HashMap<>();
        System.out.println("\nEnter correct answers:");

        for (int i = 0; i < n; i++) {
            System.out.print("Question ID: ");
            int qid = sc.nextInt();

            System.out.print("Correct Answer: ");
            String correct = sc.next();

            correctAnswers.put(qid, correct);
        }

        // Calculate score
        int score = exam.calculateScore(correctAnswers);
        System.out.println("\nFinal Score: " + score);

        // Show navigation history
        exam.showNavigationHistory();

        sc.close();
    }
}
