package scenario_based.InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer, Product> products = new HashMap<>();

    // add new product
    public void addProduct(Product product) {
        products.put(product.hashCode(), product);
    }

    // update stock
    public void updateStock(Product product, int quantity) throws OutOfStockException {
        if (quantity < 0) {
            throw new OutOfStockException("Stock cannot be negative");
        }
        product.updateQuantity(quantity);
    }

    // get all products
    public Map<Integer, Product> getProducts() {
        return products;
    }
}
