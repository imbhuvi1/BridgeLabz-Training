package gcr_codebase.streamapi;

import java.util.*;

public class EventWelcome {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList("Alice", "Bob", "Charlie");

        // Welcome each attendee
        attendees.forEach(name -> 
            System.out.println("Welcome, " + name + "!")
        );
    }
}

