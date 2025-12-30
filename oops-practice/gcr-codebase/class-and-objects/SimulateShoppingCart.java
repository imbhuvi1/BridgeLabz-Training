class CartItem{
	String itemName;
	double price;
	int quantity;
	int itemsInCart = 0;
	CartItem(String itemName, double price, int quantity){
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
	}
	public void addToCart(int quantity) {
		this.quantity += quantity;
		System.out.println("Added " + quantity + " of " + itemName + " to the cart.");
	}
	public void removeFromCart(int quantity) {
		this.quantity -= quantity;
		if(this.quantity < 0) {
			this.quantity = 0;
		}
		System.out.println("Removed " + quantity + " of " + itemName + " from the cart.");
	}
	public void displayTotalCost() {
		double totalCost = quantity * price;
		System.out.println("Total Cost: $" + totalCost);
	}
	
}
public class SimulateShoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CartItem item1 = new CartItem("Laptop", 999.99, 1);
		item1.addToCart(2);
		item1.removeFromCart(1);
		item1.displayTotalCost();
	}

}