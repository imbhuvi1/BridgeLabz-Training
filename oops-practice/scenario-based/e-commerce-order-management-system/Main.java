package scenario_based.ECommerceOrderManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product p1 = new Product(1, "Laptop", 45000);
        Product p2 = new Product(2, "Headphones", 3000);

        System.out.println("Product Catalog:");
        p1.displayProduct();
        p2.displayProduct();

        Customer customer = new Customer(101, "Rahul");

        Order order = new Order(1, p2);
        order.placeOrder();

        System.out.println("\nChoose Payment Method:");
        System.out.println("1. Card");
        System.out.println("2. UPI");
        System.out.println("3. Wallet");

        int choice = sc.nextInt();

        Payment payment = null;

        switch (choice) {
            case 1:
                payment = new CardPayment();
                break;
            case 2:
                payment = new UpiPayment();
                break;
            case 3:
                payment = new WalletPayment();
                break;
        }

        try {
            payment.pay(order.getOrderAmount());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
