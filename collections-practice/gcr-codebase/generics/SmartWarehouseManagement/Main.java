package gcr_codebase.generics.SmartWarehouseManagementSystem;

public class Main {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics");
        WarehouseUtil.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries");
        WarehouseUtil.displayItems(groceryStorage.getItems());

        System.out.println("\nFurniture");
        WarehouseUtil.displayItems(furnitureStorage.getItems());
    }
}