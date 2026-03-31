package scenario_based;

import java.util.*;

// Custom Exception
class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String msg) {
        super(msg);
    }
}

public class CinemaTime {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> movieTimes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format! Use HH:MM");
        }
        movieTitles.add(title);
        movieTimes.add(time);
        System.out.println("Movie added successfully.");
    }

    // Search movie
    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(movieTitles.get(i) + " at " + movieTimes.get(i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie found.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search error occurred.");
        }
    }

    // Display all movies
    public void displayAllMovies() {
        try {
            if (movieTitles.isEmpty()) {
                System.out.println("No movies available.");
                return;
            }
            for (int i = 0; i < movieTitles.size(); i++) {
                System.out.println((i + 1) + ". " + movieTitles.get(i) + " - " + movieTimes.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Display error.");
        }
    }

    // Convert List to Array and print
    public void printReport() {
        String[] titles = movieTitles.toArray(new String[0]);
        String[] times = movieTimes.toArray(new String[0]);

        System.out.println("\n--- Movie Report ---");
        for (int i = 0; i < titles.length; i++) {
            System.out.println(titles[i] + " at " + times[i]);
        }
    }

    // Time validation HH:MM
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        return h >= 0 && h <= 23 && m >= 0 && m <= 59;
    }

    // Menu-driven program
    public void start() {
        while (true) {
            System.out.println("\n1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Print Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter movie title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter showtime (HH:MM): ");
                        String time = sc.nextLine();
                        addMovie(title, time);
                        break;

                    case 2:
                        System.out.print("Enter keyword: ");
                        searchMovie(sc.nextLine());
                        break;

                    case 3:
                        displayAllMovies();
                        break;

                    case 4:
                        printReport();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InvalidTimeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Main
    public static void main(String[] args) {
        new CinemaTime().start();
    }
}
