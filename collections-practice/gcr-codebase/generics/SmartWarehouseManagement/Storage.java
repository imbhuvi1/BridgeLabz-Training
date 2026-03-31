package gcr_codebase.generics.SmartWarehouseManagementSystem;

import java.util.ArrayList;
import java.util.List;

class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    // Add item
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieve all items
    public List<T> getItems() {
        return items;
    }
}