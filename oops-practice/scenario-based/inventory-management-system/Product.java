package scenario_based.InventoryManagementSystem;

public class Product {

    private int productId;
    private String productName;
    private int quantity;

    public Product(int productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
}
