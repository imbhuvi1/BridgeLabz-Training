package scenario_based.InventoryManagementSystem;

public interface AlertService {

    // alert when stock is low
    void sendLowStockAlert(Product product);
}
