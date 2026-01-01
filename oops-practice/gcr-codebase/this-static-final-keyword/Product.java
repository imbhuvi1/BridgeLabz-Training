package gcr_codebase.this_static_final_keywords;

public class Product {
	
	//instance variables
	String productName;
	double price;
	int quantity;
	
	final int productID;
	
	//discount 
	static double discount = 10;
	
	//method to modify the discount percentage
	public double updateDiscount(double discountChange) {
		discount = discountChange;
		return discount;
	}
	
	//constructor
	public Product(int productID,String productName, double price, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}	
	
	//method to display product details
	public void displayDetails(Product obj) {
		if(obj instanceof Product) {
			System.out.println("Product ID: "+productID);
			System.out.println("Product Name: "+productName);
			System.out.println("Price: "+price);
			System.out.println("Quantity: "+quantity);
			System.out.println("Discount: "+discount);
			
			double priceAfterDiscount = price - price*(discount/100);
			System.out.println("Price after Discount: Rs."+priceAfterDiscount);
			System.out.println();
		}else {
			System.out.println("Invalid Instance");
		}
		
	}
	//main method
	public static void main(String[] args) {
		Product obj = new Product(101, "Water Bottle", 699, 3);
		
		obj.displayDetails(obj);
		
		Product obj1 = new Product(102, "ASUS Tuf Gaming Laptop", 50000, 10);
		
		//updating the 
		obj1.updateDiscount(20);
		obj1.displayDetails(obj1);
	}
}
