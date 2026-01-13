package scenario_based.InventoryManagementSystem;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        AlertService alertService = new AlertServiceImpl();

        Product p1 = new Product(101, "Keyboard", 10);
        Product p2 = new Product(102, "Mouse", 3);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        try {
            inventory.updateStock(p2, 2); // update quantity
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        // check low stock
        alertService.sendLowStockAlert(p1);
        alertService.sendLowStockAlert(p2);
    }
}
