package scenario_based;

import java.util.*;

class TableAlreadyReservedException extends Exception{
	public TableAlreadyReservedException(String message) {
		super(message);
	}
}

class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " (Capacity: " + capacity + ")";
    }
}

class Reservation {
    private String customerName;
    private int tableNumber;
    private String timeSlot; // Example: "7PM-9PM"

    public Reservation(String customerName, int tableNumber, String timeSlot) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Reservation for " + customerName +
               " at Table " + tableNumber +
               " during " + timeSlot;
    }
}

class Restaurant {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Add tables to restaurant
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    // Reserve table
    public void reserveTable(String customerName, int tableNumber, String timeSlot) throws TableAlreadyReservedException {

        // Check if table exists
        if (!tables.containsKey(tableNumber)) {
            System.out.println("Table does not exist!");
            return;
        }

        // Check for double booking
        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(customerName, tableNumber, timeSlot));
        System.out.println("Reservation successful!");
    }

    // Cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot)) {
                iterator.remove();
                found = true;
                System.out.println("Reservation cancelled.");
                break;
            }
        }

        if (!found) {
            System.out.println("No reservation found to cancel.");
        }
    }

    // Show available tables for a time slot
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean isReserved = false;

            for (Reservation r : reservations) {
                if (r.getTableNumber() == table.getTableNumber() &&
                    r.getTimeSlot().equals(timeSlot)) {
                    isReserved = true;
                    break;
                }
            }

            if (!isReserved) {
                System.out.println(table);
            }
        }
    }
}


public class RestaurantTableReservationSystem {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        // Predefined tables
        restaurant.addTable(new Table(1, 4));
        restaurant.addTable(new Table(2, 2));
        restaurant.addTable(new Table(3, 6));

        while (true) {
            System.out.println("\n=== Restaurant Reservation System ===");
            System.out.println("1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter table number: ");
                        int tableNumber = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter time slot (e.g., 7PM-9PM): ");
                        String timeSlot = sc.nextLine();

                        restaurant.reserveTable(name, tableNumber, timeSlot);

                    } catch (TableAlreadyReservedException e) {
                        System.out.println("⚠ " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter table number: ");
                    int tableNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter time slot: ");
                    String timeSlot = sc.nextLine();

                    restaurant.cancelReservation(tableNumber, timeSlot);
                    break;

                case 3:
                    System.out.print("Enter time slot: ");
                    String slot = sc.nextLine();
                    restaurant.showAvailableTables(slot);
                    break;

                case 4:
                    System.out.println("Thank you! Visit again.");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
	}
}
