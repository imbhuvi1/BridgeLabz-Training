import java.util.Scanner;

// Node class for inventory item
class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    // Constructor to initialize item details
    InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Singly Linked List for Inventory
class InventoryList {
    private InventoryNode head;

    // Add item at beginning
    void addAtBeginning(InventoryNode newNode) {
        newNode.next = head;
        head = newNode;
    }

    // Add item at end
    void addAtEnd(InventoryNode newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        InventoryNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Add item at specific position
    void addAtPosition(InventoryNode newNode, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(newNode);
            return;
        }

        InventoryNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove item using Item ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed successfully");
            return;
        }

        InventoryNode temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully");
        }
    }

    // Update quantity using Item ID
    void updateQuantity(int id, int newQty) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search item by ID
    void searchById(int id) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search item by Name
    void searchByName(String name) {
        InventoryNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Item not found");
    }

    // Display all inventory items
    void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        InventoryNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Display single item details
    void displayItem(InventoryNode node) {
        System.out.println("ID: " + node.itemId +
                ", Name: " + node.itemName +
                ", Quantity: " + node.quantity +
                ", Price: ₹" + node.price);
    }

    // Calculate total inventory value
    void totalInventoryValue() {
        double total = 0;
        InventoryNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Sort inventory by item name
    void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    // Sort inventory by price
    void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    // Merge sort for linked list
    private InventoryNode mergeSort(InventoryNode node, boolean asc, boolean byName) {
        if (node == null || node.next == null)
            return node;

        InventoryNode mid = getMiddle(node);
        InventoryNode nextMid = mid.next;
        mid.next = null;

        InventoryNode left = mergeSort(node, asc, byName);
        InventoryNode right = mergeSort(nextMid, asc, byName);

        return merge(left, right, asc, byName);
    }

    // Merge two sorted linked lists
    private InventoryNode merge(InventoryNode a, InventoryNode b, boolean asc, boolean byName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName)
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                            : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else
            condition = asc ? a.price <= b.price : a.price > b.price;

        InventoryNode result;
        if (condition) {
            result = a;
            result.next = merge(a.next, b, asc, byName);
        } else {
            result = b;
            result.next = merge(a, b.next, asc, byName);
        }
        return result;
    }

    // Find middle of linked list
    private InventoryNode getMiddle(InventoryNode node) {
        InventoryNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// Main class
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList list = new InventoryList();

        while (true) {
            System.out.println("\nInventory Menu");
            System.out.println("1 Add Item");
            System.out.println("2 Remove Item");
            System.out.println("3 Update Quantity");
            System.out.println("4 Search Item");
            System.out.println("5 Display Inventory");
            System.out.println("6 Total Inventory Value");
            System.out.println("7 Sort Inventory");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Item ID: ");
                    int id = sc.nextInt();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    InventoryNode node = new InventoryNode(name, id, qty, price);

                    System.out.print("1 Beginning 2 End 3 Position: ");
                    int posChoice = sc.nextInt();
                    if (posChoice == 1)
                        list.addAtBeginning(node);
                    else if (posChoice == 2)
                        list.addAtEnd(node);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(node, pos);
                    }
                    break;

                case 2:
                    System.out.print("Enter Item ID: ");
                    list.removeById(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    list.updateQuantity(uid, sc.nextInt());
                    break;

                case 4:
                    System.out.print("1 Search by ID 2 Search by Name: ");
                    int s = sc.nextInt();
                    if (s == 1) {
                        System.out.print("Enter ID: ");
                        list.searchById(sc.nextInt());
                    } else {
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        list.searchByName(sc.nextLine());
                    }
                    break;

                case 5:
                    list.displayInventory();
                    break;

                case 6:
                    list.totalInventoryValue();
                    break;

                case 7:
                    System.out.print("1 Sort by Name 2 Sort by Price: ");
                    int sortType = sc.nextInt();
                    System.out.print("1 Ascending 2 Descending: ");
                    boolean asc = sc.nextInt() == 1;

                    if (sortType == 1)
                        list.sortByName(asc);
                    else
                        list.sortByPrice(asc);
                    break;

                case 0:
                    System.out.println("Exiting program");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
