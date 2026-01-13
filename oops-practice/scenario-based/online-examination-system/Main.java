package scenario_based.OnlineExaminationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String sname = sc.nextLine();

        Student student = new Student(sid, sname);

        System.out.print("Enter Exam Name: ");
        String examName = sc.nextLine();

        Exam exam = new Exam(examName);

        // creating questions
        exam.addQuestion(new Question(1, "Java is OOP? (yes/no)", "yes"));
        exam.addQuestion(new Question(2, "2 + 2 = ?", "4"));

        List<String> answers = new ArrayList<>();

        try {
            System.out.print("Has exam time expired? (yes/no): ");
            String timeStatus = sc.nextLine();

            if (timeStatus.equalsIgnoreCase("yes")) {
                throw new ExamTimeExpiredException("Exam time expired!");
            }

            // answer submission
            for (Question q : exam.getQuestions()) {
                System.out.println(q.getQuestionText());
                answers.add(sc.nextLine());
            }

            System.out.println("Choose Evaluation Type:");
            System.out.println("1. Objective");
            System.out.println("2. Descriptive");

            int choice = sc.nextInt();

            EvaluationStrategy evaluation;
            if (choice == 1) {
                evaluation = new ObjectiveEvaluation();
            } else {
                evaluation = new DescriptiveEvaluation();
            }

            int result = evaluation.evaluate(exam.getQuestions(), answers);
            System.out.println(student.getName() + " scored: " + result);

        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
