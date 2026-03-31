package gcr_codebase.lambda_expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@FunctionalInterface
interface LightBehavior {
    void activate();
}

public class SmartHomeLighting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Map to store triggers and behaviors
        Map<String, LightBehavior> lightingModes = new HashMap<>();

        lightingModes.put("motion", () ->
                System.out.println("Motion detected: Turning hallway lights to 40% brightness."));

        lightingModes.put("evening", () ->
                System.out.println("Evening mode: Switching to warm ambient lighting."));

        lightingModes.put("night", () ->
                System.out.println("Night mode: Turning on night lamp at 20% brightness."));

        lightingModes.put("party", () ->
                System.out.println("Party mode activated: Lights changing colors with music!"));

        lightingModes.put("reading", () ->
                System.out.println("Reading mode: Bright white light focused on reading area."));

        // Ask user for input
        System.out.println("Available triggers: motion, evening, night, party, reading");
        System.out.print("Enter lighting trigger: ");
        String userTrigger = sc.nextLine().toLowerCase();

        // Execute corresponding lambda
        LightBehavior behavior = lightingModes.get(userTrigger);

        if (behavior != null) {
            behavior.activate();
        } else {
            System.out.println("Invalid trigger! No lighting behavior found.");
        }

        sc.close();
    }
}

