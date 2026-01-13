package scenario_based.TrafficManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Roundabout roundabout = new Roundabout();
        WaitingQueue queue = new WaitingQueue(3);

        while (true) {
            System.out.println("\n1. Add Vehicle to Queue");
            System.out.println("2. Move Vehicle to Roundabout");
            System.out.println("3. Remove Vehicle from Roundabout");
            System.out.println("4. Display Roundabout");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    queue.enqueue(sc.nextLine());
                    break;

                case 2:
                    String v = queue.dequeue();
                    if (v != null)
                        roundabout.addVehicle(v);
                    break;

                case 3:
                    roundabout.removeVehicle();
                    break;

                case 4:
                    roundabout.display();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
