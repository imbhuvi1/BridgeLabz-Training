package gcrcodebase.strings;

import java.util.Scanner;

public class RockPaperScissors {

    static String computerChoice() {
        int r = (int) (Math.random() * 3);
        return r == 0 ? "rock" : r == 1 ? "paper" : "scissors";
    }

    static String findWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";

        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return "User";

        return "Computer";
    }

    static String[][] calculateStats(int userWin, int compWin, int games) {
        String[][] stats = new String[2][3];

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWin);
        stats[0][2] = String.valueOf(Math.round((userWin * 100.0) / games));

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWin);
        stats[1][2] = String.valueOf(Math.round((compWin * 100.0) / games));

        return stats;
    }

    static void displayStats(String[][] stats) {
        System.out.println("\nPlayer\tWins\tWin %");

        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "%");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        int userWin = 0, compWin = 0;

        for (int i = 1; i <= games; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user = sc.next();
            String comp = computerChoice();

            String winner = findWinner(user, comp);
            System.out.println("Computer chose: " + comp);

            if (winner.equals("User")) userWin++;
            else if (winner.equals("Computer")) compWin++;
        }

        String[][] stats = calculateStats(userWin, compWin, games);
        displayStats(stats);
    }
}
