package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

// Interface for taxable products
interface Taxable {
    double calculateTax(double price);
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {

    private int productId;
    private String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract discount method
    public abstract double calculateDiscount();

    // Encapsulation using setters and getters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics class (Taxable)
class Electronics extends Product implements Taxable {

    double discountPercent;

    public Electronics(int productId, String name, double price, double discountPercent) {
        super(productId, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateDiscount() {
        return price * (discountPercent / 100);
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "GST 18% on Electronics";
    }
}

// Clothing class (Taxable)
class Clothing extends Product implements Taxable {

    double discountPercent;

    public Clothing(int productId, String name, double price, double discountPercent) {
        super(productId, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateDiscount() {
        return price * (discountPercent / 100);
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.12;
    }

    @Override
    public String getTaxDetails() {
        return "GST 12% on Clothing";
    }
}

// Groceries class (Non-taxable)
class Groceries extends Product {

    double discountPercent;

    public Groceries(int productId, String name, double price, double discountPercent) {
        super(productId, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateDiscount() {
        return price * (discountPercent / 100);
    }
}

// Main class
public class ECommercePlatform {

    // Polymorphic method
	public static void printFinalPrice(Product product) {

	    double tax = 0;

	    if (product instanceof Taxable) {
	        tax = ((Taxable) product).calculateTax(product.getPrice());
	    }

	    double discount = product.calculateDiscount();
	    double finalPrice = product.getPrice() + tax - discount;

	    product.displayDetails();

	    System.out.println("Tax: " + tax);
	    System.out.println("Discount: " + discount);
	    System.out.println("Final Price: " + finalPrice);
	    System.out.println();
	}


    public static void main(String[] args) {

        Product p1 = new Electronics(101, "Laptop", 60000, 10);
        Product p2 = new Clothing(102, "Jacket", 4000, 20);
        Product p3 = new Groceries(103, "Rice", 1200, 5);

        printFinalPrice(p1);
        printFinalPrice(p2);
        printFinalPrice(p3);
    }
}
