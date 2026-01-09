

import java.util.Scanner;

/*
 * Node class representing each movie
 * Each node contains movie details and
 * pointers to both previous and next nodes
 */
class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode prev; // Pointer to previous node
    MovieNode next; // Pointer to next node

    // Constructor to initialize movie details
    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

/*
 * Doubly Linked List class for managing movies
 */
class MovieDoublyLinkedList {
    MovieNode head; // First node
    MovieNode tail; // Last node

    // Add movie at the beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        // If list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add movie at the end
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        // If list is empty
        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Add movie at a specific position
    void addAtPosition(int position, String title, String director, int year, double rating) {

        // Insert at beginning if position is 1
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;

        // Traverse to the node before the given position
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is invalid or insert at end
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove a movie by title
    void removeByTitle(String title) {

        // If list is empty
        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }

        MovieNode temp = head;

        // Search movie by title
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        // If movie not found
        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }

        // If deleting head
        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        }
        // If deleting tail
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // If deleting middle node
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie removed successfully.");
    }

    // Search movie by director
    void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director.");
    }

    // Search movie by rating
    void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating.");
    }

    // Update movie rating by title
    void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found!");
    }

    // Display movies in forward direction
    void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display movies in reverse direction
    void displayReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }

        MovieNode temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Display a single movie record
    void displayMovie(MovieNode m) {
        System.out.println("----------------------------");
        System.out.println("Title    : " + m.title);
        System.out.println("Director : " + m.director);
        System.out.println("Year     : " + m.year);
        System.out.println("Rating   : " + m.rating);
    }
}

/*
 * Main class containing menu-driven program
 */
public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        while (true) {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display Movies Forward");
            System.out.println("8. Display Movies Reverse");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Title Director Year Rating: ");
                    list.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Title Director Year Rating: ");
                    list.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Position Title Director Year Rating: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(pos, sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    System.out.print("Enter Movie Title: ");
                    list.removeByTitle(sc.next());
                    break;

                case 5:
                    System.out.print("Enter Director Name: ");
                    list.searchByDirector(sc.next());
                    break;

                case 6:
                    System.out.print("Enter Rating: ");
                    list.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    list.displayForward();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.print("Title New Rating: ");
                    list.updateRating(sc.next(), sc.nextDouble());
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

