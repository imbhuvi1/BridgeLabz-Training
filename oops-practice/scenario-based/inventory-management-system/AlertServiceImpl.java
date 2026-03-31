package scenario_based.InventoryManagementSystem;

public class AlertServiceImpl implements AlertService {

    private static final int LOW_STOCK_LIMIT = 5;

    @Override
    public void sendLowStockAlert(Product product) {
        if (product.getQuantity() <= LOW_STOCK_LIMIT) {
            System.out.println("⚠ Low Stock Alert: " + product.getProductName());
        }
    }
}
