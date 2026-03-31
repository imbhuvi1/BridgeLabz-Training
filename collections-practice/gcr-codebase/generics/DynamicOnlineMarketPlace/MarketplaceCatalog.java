package gcr_codebase.generics.DynamicOnlineMarketplace;

import java.util.ArrayList;
import java.util.List;

class MarketplaceCatalog {

    private List<Product<? extends ProductCategory>> products = new ArrayList<>();

    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<? extends ProductCategory> p : products) {
            p.display();
        }
    }
}