package scenerio_based;

import java.util.ArrayList;
import java.util.Scanner;

//Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

//Quiz Processor Class
class QuizProcessor {

    private static final String[] correctAnswers = {"A", "B", "C", "D", "A"};

    private static ArrayList<Integer> scores = new ArrayList<>();

    //Compare answers and calculate score
    public static int calculateScore(String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Number of answers does not match the quiz length");
        }

        int score = 0;

        for (int i=0; i<correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }

        scores.add(score);
        return score;
    }

    //Return grade based on score
    public static String getGrade(int score) {

        if (score == 5)
            return "A";
        else if (score >= 4)
            return "B";
        else if (score >= 3)
            return "C";
        else
            return "Fail";
    }

    //Display all user scores
    public static void showAllScores() {
        System.out.println("\nAll User Scores:");
        for (int s : scores) {
            System.out.println("Score: " + s);
        }
    }
}

//Main Class
public class OnlineQuizPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter answers for 5 questions:");

            String[] userAnswers = new String[5];

            for (int i=0; i<userAnswers.length; i++) {
                System.out.print("Answer " +(i+1)+ ": ");
                userAnswers[i] = sc.next();
            }

            int score = QuizProcessor.calculateScore(userAnswers);
            String grade = QuizProcessor.getGrade(score);

            System.out.println("\nScore: " + score);
            System.out.println("Grade: " + grade);

            QuizProcessor.showAllScores();

        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Submission Error: " + e.getMessage());
        }

        sc.close();
    }
}
