package gcr_codebase.generics.DynamicOnlineMarketplace;
class Product<T extends ProductCategory> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println(
            "Product: " + name +
            " | Category: " + category.getCategoryName() +
            " | Price: ₹" + price
        );
    }
}