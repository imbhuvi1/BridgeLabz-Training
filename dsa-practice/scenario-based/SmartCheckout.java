package scenario_based;

import java.util.*;

//Represents a product in the store
class Product {
 String name;
 double price;
 int stock;

 Product(String name, double price, int stock) {
     this.name = name;
     this.price = price;
     this.stock = stock;
 }
}

//Represents a customer with a shopping cart
class Customer {
 String customerName;
 Map<String, Integer> cart; // Item name → quantity

 Customer(String customerName) {
     this.customerName = customerName;
     this.cart = new HashMap<>();
 }

 // Add item and quantity to cart
 void addItem(String itemName, int quantity) {
     cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
 }
}

public class SmartCheckout {

 // Queue for customers waiting at billing counter
 private Queue<Customer> checkoutQueue = new LinkedList<>();

 // HashMap for fast product lookup (item name → Product)
 private Map<String, Product> inventory = new HashMap<>();


 // Add a product to store inventory
 public void addProductToInventory(String name, double price, int stock) {
     inventory.put(name, new Product(name, price, stock));
 }

 // Add a customer to the checkout queue
 public void addCustomer(Customer customer) {
     checkoutQueue.offer(customer);
     System.out.println(customer.customerName + " joined the queue.");
 }

 // Remove customer after billing is complete
 public void processNextCustomer() {
     if (checkoutQueue.isEmpty()) {
         System.out.println("No customers in queue.");
         return;
     }

     Customer customer = checkoutQueue.poll(); // Remove from queue
     System.out.println("\nProcessing bill for " + customer.customerName);

     double totalBill = 0.0;

     // Go through each item in customer's cart
     for (Map.Entry<String, Integer> entry : customer.cart.entrySet()) {
         String itemName = entry.getKey();
         int quantityNeeded = entry.getValue();

         // Fetch product details quickly using HashMap
         Product product = inventory.get(itemName);

         if (product == null) {
             System.out.println("Item " + itemName + " not found in store.");
             continue;
         }

         if (product.stock >= quantityNeeded) {
             double itemCost = product.price * quantityNeeded;
             totalBill += itemCost;
             product.stock -= quantityNeeded; // Update stock after purchase

             System.out.println(itemName + " x " + quantityNeeded +
                     " = ₹" + itemCost + " (Stock left: " + product.stock + ")");
         } else {
             System.out.println("Not enough stock for " + itemName +
                     ". Available: " + product.stock);
         }
     }

     System.out.println("Total Bill for " + customer.customerName + " = ₹" + totalBill);
     System.out.println(customer.customerName + " has left the counter.");
 }


 // Display remaining stock in inventory
 public void showInventory() {
     System.out.println("\nCurrent Inventory:");
     for (Product p : inventory.values()) {
         System.out.println(p.name + " - Price: ₹" + p.price + ", Stock: " + p.stock);
     }
 }


 // Main method to simulate the system
 public static void main(String[] args) {

     SmartCheckout store = new SmartCheckout();

     // Add products to inventory
     store.addProductToInventory("Milk", 50, 20);
     store.addProductToInventory("Bread", 30, 15);
     store.addProductToInventory("Eggs", 6, 100);
     store.addProductToInventory("Rice", 60, 10);

     // Create customers and their carts
     Customer c1 = new Customer("Rahul");
     c1.addItem("Milk", 2);
     c1.addItem("Bread", 1);

     Customer c2 = new Customer("Ananya");
     c2.addItem("Eggs", 12);
     c2.addItem("Rice", 2);

     Customer c3 = new Customer("Vikram");
     c3.addItem("Milk", 5);
     c3.addItem("Eggs", 30);

     // Add customers to billing queue
     store.addCustomer(c1);
     store.addCustomer(c2);
     store.addCustomer(c3);

     // Process customers one by one (FIFO order)
     store.processNextCustomer();
     store.processNextCustomer();
     store.processNextCustomer();

     // Show remaining stock after all purchases
     store.showInventory();
 }
}
