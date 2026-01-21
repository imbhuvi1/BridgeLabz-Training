package gcr_codebase.generics.SmartWarehouseManagementSystem;

import java.util.*;
class WarehouseUtil {

    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println("Item: " + item.getName() + " | Category: " + item.getCategory()
            );
        }
    }
}