package scenario_based.ECommerceOrderManagementSystem;

import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private Product product;
    private LocalDateTime orderTime;
    private boolean cancelled;

    public Order(int orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
        this.orderTime = LocalDateTime.now();
        this.cancelled = false;
    }

    public double getOrderAmount() {
        return product.getPrice();
    }

    public void placeOrder() {
        System.out.println("Order ID " + orderId + " placed at " + orderTime);
    }

    public void cancelOrder() {
        cancelled = true;
        System.out.println("Order ID " + orderId + " cancelled.");
    }
}
