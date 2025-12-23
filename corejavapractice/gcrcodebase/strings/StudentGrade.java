package gcrcodebase.strings;

import java.util.Random;

public class StudentGrade {

    // Generate PCM scores
    static int[][] generateScores(int n) {
        Random r = new Random();
        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {
            scores[i][0] = r.nextInt(90) + 10;
            scores[i][1] = r.nextInt(90) + 10;
            scores[i][2] = r.nextInt(90) + 10;
        }
        return scores;
    }

    // Calculate total, average, percentage
    static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = Math.round((total / 3.0) * 100) / 100.0;
            double percent = Math.round((total / 3.0) * 100) / 100.0;

            result[i][0] = total;
            result[i][1] = avg;
            result[i][2] = percent;
        }
        return result;
    }

    // Calculate grade
    static String[] calculateGrade(double[][] result) {
        String[] grade = new String[result.length];

        for (int i = 0; i < result.length; i++) {
            double p = result[i][2];

            if (p >= 80) grade[i] = "A";
            else if (p >= 70) grade[i] = "B";
            else if (p >= 60) grade[i] = "C";
            else if (p >= 50) grade[i] = "D";
            else if (p >= 40) grade[i] = "E";
            else grade[i] = "R";
        }
        return grade;
    }

    // Display scorecard
    static void display(int[][] scores, double[][] result, String[] grade) {
        System.out.println("Phy Chem Math Total Avg % Grade");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0] + "  " +scores[i][1] + "  " +scores[i][2] + "  " +(int) result[i][0] + "  " +result[i][1] + "  " +result[i][2] + "  " +grade[i]);
        }
    }

    public static void main(String[] args) {
        int students = 5;

        int[][] scores = generateScores(students);
        double[][] result = calculateResults(scores);
        String[] grade = calculateGrade(result);

        display(scores, result, grade);
    }
}
