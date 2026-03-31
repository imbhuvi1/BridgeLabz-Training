package gcr_codebase.generics.SmartWarehouseManagementSystem;

class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}
